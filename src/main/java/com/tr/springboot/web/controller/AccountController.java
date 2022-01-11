package com.tr.springboot.web.controller;

import com.tr.springboot.web.dao.jpa.AccountJpa;
import com.tr.springboot.web.entity.Account;
import com.tr.springboot.web.service.AccountService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 用于事务测试：账户类
 *
 * @author TR
 * @date 8/10/2020 4:05 PM
 */
@Api(tags = "Account")
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @Resource
    private AccountJpa accountJpa;

    /**
     * 与下面 /transfer2 对比测试
     */
    @GetMapping("/transfer")
    public void transfer() {
        accountService.transfer();
    }

    /**
     * transfer2 和 transfer 方法执行的代码一模一样
     * 执行结果却不一样
     * 若 transferAccounts() 事务方法内部错误
     * transfer 整个不受事务影响，事务方法已经执行的内容也生效
     * transfer2 中非事务方法生效，事务方法被回滚不生效
     * 二者唯一的区别：一个在Service调用事务方法，一个在Controller调用事务方法
     * 如同：A-普通Service方法 B-事务Service方法 C-普通Controller方法
     *      A调用B，B出错，A B 都不受事务影响（前提：A、B在同一个Service中）
     *      C调用B，B出粗，C 不受事务影响，B 照样受事务影响
     *
     * 网上查阅资料：https://msd.misuland.com/pd/3127746505234974906
     * 解决办法：可以把方法B放到另外一个service或者dao，然后把这个service或者dao通过@Autowired注入到方法A里面，
     *          这样即使方法A没用事务，方法B也可以执行自己的事务了。
     * 结论：意思就是同一个Service类里面的 非事务方法A 调用 事务方法B 才会出现AB都不受事务影响，
     *       A B 不属于同一个Service类没有上述问题，A不受事务影响，B受事务影响（理想状态）。
     */
    @GetMapping("/transfer2")
    public void transferRunInController() {
        // before 事务（测试结果：下面的事务方法失败后不影响前面已经执行的结果）
        Account accountB = accountJpa.getOne(2);
        accountB.setName(accountB.getName() + "-1");
        accountJpa.save(accountB);

        // 事务方法
        accountService.transferAccounts(1,2, 200d);
    }

    @GetMapping("/reset-data")
    public void resetData() {
        accountService.resetData();
    }

}