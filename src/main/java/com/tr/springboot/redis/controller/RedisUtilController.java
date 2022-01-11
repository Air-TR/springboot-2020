package com.tr.springboot.redis.controller;

import com.tr.springboot.redis.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * RedisUtil 功能测试
 *
 * @author taorun
 * 2020-08-09 18:29
 */
@Api(tags = "RedisUtil")
@RestController
public class RedisUtilController {

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(value = "保存到 redis", notes = "保存到 redis")
    @GetMapping("/redisUtil/set")
    public void set(@ApiParam(value = "传入key值") @RequestParam String key,
                    @ApiParam(value = "传入value值") @RequestParam String value) {
        redisUtil.set(key, value);
        redisUtil.set(key, value, 10); // 带失效时间
    }

    @ApiOperation(value = "根据 key 获取缓存", notes = "根据 key 获取缓存")
    @GetMapping("/redisUtil/get")
    public Object get(@RequestParam String key) {
        return redisUtil.get(key);
    }

    @ApiOperation(value = "获取 redis 中所有 key-value 值", notes = "获取 redis 中所有 key-value 值")
    @GetMapping("/redisUtil/allKeyValues")
    public Map<String, Object> allKeyValues() {
        Set<String> keys = redisUtil.keys("*");
        Iterator<String> iterator = keys.iterator();
        Map<String, Object> map = new HashMap<>();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object o = redisUtil.get(key);
            map.put(key, o);
        }
        return map;
    }

    @ApiOperation(value = "清除 redis 所有缓存", notes = "清除 redis 所有缓存")
    @DeleteMapping("/redisUtil/deleteAll")
    public String deleteAll() {
        Set<String> keys = redisUtil.keys("*");
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            redisUtil.del(iterator.next());
        }
        return "删除 redis 所有数据成功";
    }

}
