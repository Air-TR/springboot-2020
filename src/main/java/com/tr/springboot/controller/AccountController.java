package com.tr.springboot.controller;

import com.tr.springboot.service.AccountService;
import com.tr.springboot.dao.jpa.AccountRepository;
import com.tr.springboot.entity.Account;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Api(tags = "Account", description = "账户")
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/transfer")
    public void transfer() {
        // before 事务（测试结果：下面的事务方法失败后不影响前面已经执行的结果）
        Account accountB = accountRepository.getOne(2);
        accountB.setUsername(accountB.getUsername() + "-Before");
        accountRepository.save(accountB);

        // 事务方法
        accountService.transferAccounts(1,2, new BigDecimal(200));

        // after 事务（测试结果：上面的事务方法失败后下面的代码不执行）
        accountB.setUsername(accountB.getUsername() + "-After");
        accountRepository.save(accountB);
    }

    @GetMapping("/reset-data")
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

}