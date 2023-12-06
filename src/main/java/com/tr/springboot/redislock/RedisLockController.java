package com.tr.springboot.redislock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Redis 分布式锁测试
 *
 * redisLockTest() 方法的测试重点在 try 语句块中两个 lockValue 的选择，会有不同的运行结果：
 *  1.使用 simpleLock 会：T1 或 T2 线程没抢到锁，直接抛出预期的异常。
 *  2.使用 lock 会：T1 先抢到锁，经过 2 秒的处理后，锁释放，这时 T2 重试拿到了锁，继续处理，最终释放。
 *
 * @Author TR
 * @date 2022/9/7 下午2:17
 */
@RestController
public class RedisLockController {

    private static Logger logger = LoggerFactory.getLogger(RedisLockController.class);

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/redisLock/test")
    public void redisLockTest() throws InterruptedException {
        // 初始化
        RedisLock redisLock = new RedisLock(stringRedisTemplate);
        String lockKey = "lock:test";

        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch threadsLatch = new CountDownLatch(2);

        final int lockExpireSecond = 5;
        final int timeoutSecond = 3;

        Runnable lockRunnable = () -> {
            String lockValue = "";
            try {
                // 等待发令枪响，防止线程抢跑
                start.await();

                /**
                 * 以下两段 lockValue 代码选择一行使用
                 *  1.选择第一行执行效果：T1 或 T2 线程没抢到锁，直接抛出预期的异常。
                 *  2.选择第二行执行效果：T1 先抢到锁，经过 2 秒的处理后，锁释放，这时 T2 重试拿到了锁，继续处理，最终释放。
                 */
                lockValue = redisLock.simpleLock(lockKey, lockExpireSecond); // 允许丢数据的简单锁示例
//                lockValue = redisLock.lock(lockKey, lockExpireSecond, timeoutSecond); // 不允许丢数据的分布式锁示例

                // 停一会儿，故意让后面的线程抢不到锁
                TimeUnit.SECONDS.sleep(2);
                logger.info(String.format("%s get lock successfully, value:%s", Thread.currentThread().getName(), lockValue));

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                redisLock.unlock(lockKey, lockValue);
                // 执行完后，计数减 1
                threadsLatch.countDown();
            }

        };

        Thread t1 = new Thread(lockRunnable, "T1");
        Thread t2 = new Thread(lockRunnable, "T2");

        t1.start();
        t2.start();

        // 预备：开始！
        start.countDown();

        // 等待所有线程跑完
        threadsLatch.await();

        logger.info("======> done");
    }

}
