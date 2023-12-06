package com.tr.springboot.transaction.controller;

import com.tr.springboot.transaction.service.TransactionService1;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 事务测试类（AccountController 也是事务测试类）
 *  1.同一类中 T 调 M
 *  2.不同类中 T 调 M
 *  3.同一类中 M 调 T（特殊）
 *  4.不同类中 M 调 T
 *  5.同一类中 T 调 T
 *  6.不同类中 T 调 T
 *
 * @Author TR
 * @date 8/10/2020 4:06 PM
 */
@Api(tags = "Transaction")
@RestController
public class TransactionController {

    @Autowired
    TransactionService1 transactionService1;

    /**
     * 1.同一类中 T 调 M，测试结果：
     *  若 T 抛异常：T M 全部回滚
     *  若 M 抛异常：T M 全部回滚
     */
    @GetMapping("/transaction/T/invoke/innerM")
    public void tInvokeInnerM() {
        transactionService1.tInvokeInnerM();
    }

    /**
     * 2.不同类中 T 调 M，测试结果：
     *  若 T 抛异常：T M 全部回滚
     *  若 M 抛异常：T M 全部回滚
     */
    @GetMapping("/transaction/T/invoke/outM")
    public void tInvokeOutM() {
        transactionService1.tInvokeOutM();
    }

    /**
     * 3.同一类中 M 调 T
     *  若 M 抛异常：T 事务失效，M T 已执行的代码全部生效
     *  若 T 抛异常：T 事务失效，M T 已执行的代码全部生效
     */
    @GetMapping("/transaction/M/invoke/innerT")
    public void mInvokeInnerT() {
        transactionService1.mInvokeInnerT();
    }

    /**
     * 4.不同类中 M 调 T
     *  若 M 抛异常：M T 已执行的代码全部生效
     *  若 T 抛异常：T 事务生效，T 回滚，M 已执行代码生效
     */
    @GetMapping("/transaction/M/invoke/outT")
    public void mInvokeOutT() {
        transactionService1.mInvokeOutT();
    }

    /**
     * 5.同一类中 T1 调 T2
     *  若 T1 抛异常：T1 T2 全部回滚
     *  若 T2 抛异常：T1 T2 全部回滚
     */
    @GetMapping("/transaction/T/invoke/innerT")
    public void tInvokeInnerT() {
        transactionService1.tInvokeInnerT();
    }

    /**
     * 6.不同类中 T1 调 T2
     *  若 T1 抛异常：T1 T2 全部回滚
     *  若 T2 抛异常：T1 T2 全部回滚
     */
    @GetMapping("/transaction/T/invoke/outT")
    public void tInvokeOutT() {
        transactionService1.tInvokeOutT();
    }

}
