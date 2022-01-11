package com.tr.springboot.web.service.impl;

import com.tr.springboot.web.dao.jpa.AccountJpa;
import com.tr.springboot.web.entity.Account;
import com.tr.springboot.web.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountJpa accountJpa;

    @Override
    public void transfer() {
        // before 事务（测试结果：下面的事务方法失败后不影响前面已经执行的结果）
        Account accountB = accountJpa.getOne(2);
        accountB.setName(accountB.getName() + "-1");
        accountJpa.save(accountB);

        // 事务方法
        transferAccounts(1,2, 200d);

        // after 事务（测试结果：上面的事务方法失败后下面的代码不执行）
//        accountB.setName(accountB.getName() + "-2");
//        accountJpa.save(accountB);
    }

    @Override
    public void resetData() {
        Account accountA = accountJpa.getOne(1);
        Account accountB = accountJpa.getOne(2);
        double balance = 500;
        accountA.setBalance(balance);
        accountB.setBalance(balance);
        accountB.setName("B");
        accountJpa.save(accountA);
        accountJpa.save(accountB);
    }

    /**
     *
     * @author taorun
     * 2020-08-09 18:05
     */
    @Override
    @Transactional
    public void transferAccounts(int fromAccountId, int toAccountId, Double amount) {
        Account fromAccount = accountJpa.getOne(fromAccountId);
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        accountJpa.save(fromAccount); // fromUser扣钱

        Account toAccount = accountJpa.getOne(toAccountId);
        toAccount.setBalance(toAccount.getBalance() + amount);
        int e = 1 / 0; // 制造异常
        accountJpa.save(toAccount); // toUser加钱
    }

}
