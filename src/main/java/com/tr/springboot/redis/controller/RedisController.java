package com.tr.springboot.redis.controller;

import com.tr.springboot.web.dao.jpa.AccountJpa;
import com.tr.springboot.web.entity.Account;
import io.swagger.annotations.Api;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Redis 功能测试类
 *
 * @Author TR
 * @version 1.0
 * @date 2020/11/23 下午10:41
 */
@Api(tags = "Redis")
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    AccountJpa accountJpa;

    @Cacheable(value = "account")
    @GetMapping("/account/{gender}")
    public List<Account> findByGender(@PathVariable Integer gender) {
        List<Account> accounts = accountJpa.findByGender(gender);
        return accounts;
    }

//  @Cacheable(value = "account2", key = "#gender")
    @Cacheable(value = "account2")
    @GetMapping("/account/{gender}/{balance}")
    public List<Account> test(@PathVariable Integer gender, @PathVariable Double balance) {
        List<Account> accounts = accountJpa.findByGenderAndBalance(gender, balance);
        return accounts;
    }

    /**
     * 清空所有 redis 缓存数据
     *
     * @Author TR
     * @date 2022/1/10 下午6:22
     * @params []
     */
    @CacheEvict(value = "*", allEntries = true)
    @DeleteMapping("/deleteAll")
    public void deleteAll() {}

}
