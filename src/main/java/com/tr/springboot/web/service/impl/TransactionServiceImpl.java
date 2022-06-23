package com.tr.springboot.web.service.impl;

import com.tr.springboot.web.service.TransactionService;
import com.tr.springboot.web.dao.mybatis.TransactionMapper;
import com.tr.springboot.web.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    /**
     * 普通方法内部调用事务方法 transactionUpdate()
     * 看事务方法出错后，之前非事务方法执行的结果是否生效
     */
    @Override
    public void beforeTransactionUpdate() {
        Transaction t = new Transaction();
        t.setId(2);
        t.setValue4(123);
        transactionMapper.updateById(t);

        /**
         * 调用事务方法
         * 测试发现：下面的事务方法好像事务不起作用了？
         *         结果和调用普通方法一样，出错代码前的结果都生效了，包括事务方法中已经执行的部分
         */
        transactionUpdate();
    }

    @Transactional
    @Override
    public void transactionUpdate() {
        Transaction t1 = new Transaction();
        t1.setId(2);
        t1.setValue1(1);
        transactionMapper.updateById(t1);

        /**
         * 事务方法内部调用其他非事务方法
         * 测试结果：该方法也受事务影响回滚
         */
        afterTransactionUpdate();

        /**
         * 事务方法内部调用其他事务方法
         * 测试结果：所有执行都不生效
         */
        transactionUpdateOut();

        Transaction t2 = new Transaction();
        t2.setId(2);
        t2.setValue2(2);
        transactionMapper.updateById(t2);

        Transaction t3 = new Transaction();
        t3.setId(2);
        t3.setValue3(3);
        /**
         * 下面行代码：制造异常触发事务，t1、t2、t3 修改都不生效。
         * 去掉方法上的事务注解，t1修改的数据生效，从出错的t2开始都不生效（因为等同于普通方法执行，
         *  t1已经执行所以生效，还没到t2就报错，所以t2根本就没有执行，谈不上生效不生效）。
         */
        int e = 1 / 0;
        transactionMapper.updateById(t3);

    }

    @Override
    public void afterTransactionUpdate() {
        Transaction t = new Transaction();
        t.setId(3);
        t.setValue4(223);
        transactionMapper.updateById(t);
    }

    @Transactional
    public void transactionUpdateOut() {
        Transaction t = new Transaction();
        t.setId(2);
        t.setValue5(999);
//        int e = 1 / 0;
        transactionMapper.updateById(t);
    }

}
