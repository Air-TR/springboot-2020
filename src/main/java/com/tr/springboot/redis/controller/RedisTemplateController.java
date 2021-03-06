package com.tr.springboot.redis.controller;

import io.swagger.annotations.Api;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis控制类
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

    @GetMapping("/redisTemplate/set-five-data")
    public void setFiveData() {
        redisTemplate.opsForValue().set("f", "File");
        redisTemplate.opsForValue().set("e", "Edit");
        redisTemplate.opsForValue().set("v", "View");
        redisTemplate.opsForValue().set("n", "Navigate");
        redisTemplate.opsForValue().set("c", "Code");
    }

    @GetMapping("/redisTemplate/set")
    public void set(@RequestParam String key, @RequestParam String value) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, 100, TimeUnit.SECONDS);
    }

    @GetMapping("/redisTemplate/{id}")
    public Object get(@PathVariable String id) {
        return redisTemplate.opsForValue().get(id);
    }

    @DeleteMapping("/redisTemplate/{id}")
    public void delete(@PathVariable String id) {
        redisTemplate.delete(id);
    }

    /**
     * 清除所有Redis缓存数据
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
