package com.tr.springboot.redis.service.impl;

import com.tr.springboot.redis.service.RedisService;
import com.tr.springboot.web.dao.jpa.AccountRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author TR
 * @version 1.0
 * @date 2020/11/23 下午11:13
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private AccountRepository accountRepository;

    @Override
    public String getAccountName(int id) {
        return accountRepository.getOne(id).getUsername();
    }

}
