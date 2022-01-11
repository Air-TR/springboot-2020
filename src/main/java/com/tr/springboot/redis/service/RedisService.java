package com.tr.springboot.redis.service;

import com.tr.springboot.web.entity.Account;

import java.util.List;

public interface RedisService {

    List<Account> getAccountsByBalance(Double balance);

    List<String> getAccountNamesByBalance(Double balance);

}
