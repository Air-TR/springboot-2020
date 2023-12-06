package com.tr.springboot.redis.controller;

import io.swagger.annotations.Api;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * RedisTemplate 功能测试
 *
 * @author taorun
 * @version 1.0
 * @date 2020-08-09 21:56
 */
@Api(tags = "redisTemplate")
@RestController
public class RedisTemplateController {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 设置 Redis 缓存数据
     *
     * @Author TR
     * @date 2022/1/10 下午5:28
     * @params [key, value]
     */
    @GetMapping("/redisTemplate/set")
    public void set(@RequestParam String key, @RequestParam String value) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, 100, TimeUnit.SECONDS);
    }

    /**
     * 根据 key 获取缓存数据
     *
     * @Author TR
     * @date 2022/1/10 下午5:28
     * @params [id]
     */
    @GetMapping("/redisTemplate/{key}")
    public Object get(@PathVariable String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 根据 key 删除缓存数据
     *
     * @Author TR
     * @date 2022/1/10 下午5:29
     * @params [id]
     */
    @DeleteMapping("/redisTemplate/{key}")
    public void delete(@PathVariable String key) {
        redisTemplate.delete(key);
    }

    /**
     * 清除所有 Redis 缓存数据
     *
     * @author taorun
     * 2020-08-09 22:41
     * @params []
     */
    @DeleteMapping("/redisTemplate")
    public void delete() {
        Set<String> keys = redisTemplate.keys("*");
        redisTemplate.delete(keys);
    }

}
