package com.tr.springboot.transaction.service.impl;

import com.tr.springboot.transaction.service.TransactionService1;
import com.tr.springboot.transaction.service.TransactionService2;
import com.tr.springboot.web.dao.mybatis.TransactionMapper;
import com.tr.springboot.web.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author TR
 * @date 2022/8/23 下午2:55
 */
@Service
public class TransactionServiceImpl1 implements TransactionService1 {

    @Autowired
    TransactionMapper transactionMapper;

    @Autowired
    TransactionService2 transactionService2;

    @Override
    public void m() {
        Transaction t = new Transaction();
        t.setId(1);
        t.setValue2(200);
        transactionMapper.updateById(t);
//        int i = 1 / 0;
    }

    @Transactional
    @Override
    public void t() {
        Transaction t = new Transaction();
        t.setId(1);
        t.setValue2(200);
        transactionMapper.updateById(t);
//        int i = 1 / 0;
    }

    @Transactional
    @Override
    public void tInvokeInnerM() {
        Transaction t = new Transaction();
        t.setId(1);
        t.setValue1(100);
        transactionMapper.updateById(t);
        m();
//        int i = 1 / 0;
    }

    @Transactional
    @Override
    public void tInvokeOutM() {
        Transaction t = new Transaction();
        t.setId(1);
        t.setValue1(100);
        transactionMapper.updateById(t);
        transactionService2.m();
//        int i = 1 / 0;
    }

    @Override
    public void mInvokeInnerT() {
        Transaction t = new Transaction();
        t.setId(1);
        t.setValue1(100);
        transactionMapper.updateById(t);
        t();
//        int i = 1 / 0;
    }

    @Override
    public void mInvokeOutT() {
        Transaction t = new Transaction();
        t.setId(1);
        t.setValue1(100);
        transactionMapper.updateById(t);
        transactionService2.t();
//        int i = 1 / 0;
    }

    @Transactional
    @Override
    public void tInvokeInnerT() {
        Transaction t = new Transaction();
        t.setId(1);
        t.setValue1(100);
        transactionMapper.updateById(t);
        t();
//        int i = 1 / 0;
    }

    @Transactional
    @Override
    public void tInvokeOutT() {
        Transaction t = new Transaction();
        t.setId(1);
        t.setValue1(100);
        transactionMapper.updateById(t);
        transactionService2.t();
//        int i = 1 / 0;
    }

}
