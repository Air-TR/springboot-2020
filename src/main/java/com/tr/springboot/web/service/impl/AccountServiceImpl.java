package com.tr.springboot.web.service.impl;

import com.tr.springboot.web.dao.jpa.AccountRepository;
import com.tr.springboot.web.entity.Account;
import com.tr.springboot.web.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void transfer() {
        // before 事务（测试结果：下面的事务方法失败后不影响前面已经执行的结果）
        Account accountB = accountRepository.getOne(2);
        accountB.setUsername(accountB.getUsername() + "-1");
        accountRepository.save(accountB);

        // 事务方法
        transferAccounts(1,2, new BigDecimal(200));

        // after 事务（测试结果：上面的事务方法失败后下面的代码不执行）
//        accountB.setUsername(accountB.getUsername() + "-2");
//        accountRepository.save(accountB);
    }

    @Override
    public void resetData() {
        Account accountA = accountRepository.getOne(1);
        Account accountB = accountRepository.getOne(2);
        BigDecimal balance = new BigDecimal(500);
        accountA.setBalance(balance);
        accountB.setBalance(balance);
        accountB.setUsername("B");
        accountRepository.save(accountA);
        accountRepository.save(accountB);
    }

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
        accountRepository.save(fromAccount); // fromUser扣钱

        Account toAccount = accountRepository.getOne(toAccountId);
        toAccount.setBalance(toAccount.getBalance().add(account));
        int e = 1 / 0; // 制造异常
        accountRepository.save(toAccount); // toUser加钱
    }

}
