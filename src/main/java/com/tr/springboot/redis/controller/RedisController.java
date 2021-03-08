package com.tr.springboot.redis.controller;

import com.tr.springboot.redis.service.RedisService;
import io.swagger.annotations.Api;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author TR
 * @version 1.0
 * @date 2020/11/23 下午10:41
 */
@Api(tags = "Redis")
@RestController
public class RedisController {

    @Resource
    RedisService redisService;

    /**
     * @Cacheable: 每次执行前都会检查Cache中是否存在相同key的缓存元素，
     * 如果存在就不再执行该方法，直接从缓存中获取结果返回，否则才会执行方法并将返回结果存入指定的缓存中。
     *
     * @author TR
     * @date 2020/11/23 下午11:37
     */
    @Cacheable("accountName")
    @GetMapping("/redis/accountName/{id}")
    public String getByKey(@PathVariable int id) {
        return redisService.getAccountName(id);
    }

}
