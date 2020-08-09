package com.tr.springboot.service.impl;

import com.tr.springboot.service.AccountService;
import com.tr.springboot.dao.jpa.AccountRepository;
import com.tr.springboot.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    /**
     *
     * @author taorun
     * 2020-08-09 18:05
     */
    @Override
    @Transactional
    public void transferAccounts(int fromAccountId, int toAccountId, BigDecimal account) {
        Account fromAccount = accountRepository.getOne(fromAccountId);
        fromAccount.setBalance(fromAccount.getBalance().subtract(account));
        accountRepository.save(fromAccount); // fromUser扣钱​

        Account toAccount = accountRepository.getOne(toAccountId);
        toAccount.setBalance(toAccount.getBalance().add(account));
        int e = 1 / 0; // 制造异常
        accountRepository.save(toAccount); // toUser加钱
    }

}
