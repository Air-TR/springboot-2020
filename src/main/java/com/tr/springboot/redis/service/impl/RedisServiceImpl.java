package com.tr.springboot.redis.service.impl;

import com.tr.springboot.redis.service.RedisService;
import com.tr.springboot.web.dao.jpa.AccountJpa;
import com.tr.springboot.web.entity.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author TR
 * @version 1.0
 * @date 2020/11/23 下午11:13
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private AccountJpa accountJpa;

    @Override
    public List<Account> getAccountsByBalance(Double balance) {
        return accountJpa.findByBalance(balance);
    }

    @Override
    public List<String> getAccountNamesByBalance(Double balance) {
        return accountJpa.findNameByBalance(balance);
    }

}
