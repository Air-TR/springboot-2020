package com.tr.springboot.redislock;

import com.tr.springboot.web.common.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 利用 redis 获取分布式锁
 *
 * @Author TR
 * @date 2022/9/7 下午2:16
 * @link https://www.cnblogs.com/yjmyzz/p/distribution-lock-using-redis.html
 */
public class RedisLock {

    private StringRedisTemplate redisTemplate;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /** simple lock 尝试获取锅的次数 */
    private int retryCount = 3;

    /** 每次尝试获取锁的重试间隔毫秒数 */
    private int waitIntervalInMS = 100;


    public RedisLock(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 利用 redis 获取分布式锁(未获取锁的请求，允许丢弃!)
     *
     * @param redisKey       锁的 key 值
     * @param expireInSecond 锁的自动释放时间(秒)
     */
    public String simpleLock(final String redisKey, final int expireInSecond) {
        String lockValue = UUID.randomUUID().toString();
        boolean flag = false;
        if (StringUtils.isEmpty(redisKey)) {
            throw new MyException("key is empty!");
        }
        if (expireInSecond <= 0) {
            throw new MyException("expireInSecond must be bigger than 0");
        }
        try {
            for (int i = 0; i < retryCount; i++) {
                boolean success = redisTemplate.opsForValue().setIfAbsent(redisKey, lockValue, expireInSecond, TimeUnit.SECONDS);
                if (success) {
                    flag = true;
                    break;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(waitIntervalInMS);
                } catch (Exception ignore) {
                    logger.warn("redis lock fail: " + ignore.getMessage());

                }
            }
            if (!flag) {
                throw new MyException(Thread.currentThread().getName() + " cannot acquire lock now ...");
            }
            return lockValue;
        } catch (MyException e) {
            throw e;
        } catch (Exception e) {
            logger.warn("get redis lock error, exception: " + e.getMessage());
            throw e;
        }
    }

    /**
     * 利用 redis 获取分布式锁(未获取锁的请求，将在 timeoutSecond 时间范围内，一直等待重试)
     *
     * @param redisKey       锁的 key 值
     * @param expireInSecond 锁的自动释放时间(秒)
     * @param timeoutSecond  未获取到锁的请求，尝试重试的最久等待时间(秒)
     */
    public String lock(final String redisKey, final int expireInSecond, final int timeoutSecond) {
        String lockValue = UUID.randomUUID().toString();
        boolean flag = false;
        if (StringUtils.isEmpty(redisKey)) {
            throw new MyException("key is empty!");
        }
        if (expireInSecond <= 0) {
            throw new MyException("expireInSecond must be greater than 0");
        }
        if (timeoutSecond <= 0) {
            throw new MyException("timeoutSecond must be greater than 0");
        }
        if (timeoutSecond >= expireInSecond) {
            throw new MyException("timeoutSecond must be less than expireInSecond");
        }
        try {
            long timeoutAt = System.currentTimeMillis() + timeoutSecond * 1000;
            while (true) {
                boolean success = redisTemplate.opsForValue().setIfAbsent(redisKey, lockValue, expireInSecond, TimeUnit.SECONDS);
                if (success) {
                    flag = true;
                    break;
                }
                if (System.currentTimeMillis() >= timeoutAt) {
                    break;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(waitIntervalInMS);
                } catch (Exception ignore) {
                    logger.warn("redis lock fail: " + ignore.getMessage());
                }
            }
            if (!flag) {
                throw new MyException(Thread.currentThread().getName() + " cannot acquire lock now ...");
            }
            return lockValue;
        } catch (MyException e) {
            throw e;
        } catch (Exception e) {
            logger.warn("get redis lock error, exception: " + e.getMessage());
            throw e;
        }
    }


    /**
     * 锁释放
     *
     * @param redisKey
     * @param lockValue
     */
    public void unlock(final String redisKey, final String lockValue) {
        if (StringUtils.isEmpty(redisKey)) {
            return;
        }
        if (StringUtils.isEmpty(lockValue)) {
            return;
        }
        try {
            String currLockVal = redisTemplate.opsForValue().get(redisKey);
            if (currLockVal != null && currLockVal.equals(lockValue)) {
                boolean result = redisTemplate.delete(redisKey);
                if (!result) {
                    logger.warn(Thread.currentThread().getName() + " unlock redis lock fail");
                } else {
                    logger.info(Thread.currentThread().getName() + " unlock redis lock:" + redisKey + " successfully!");
                }
            }
        } catch (Exception je) {
            logger.warn(Thread.currentThread().getName() + " unlock redis lock error:" + je.getMessage());
        }
    }

}
