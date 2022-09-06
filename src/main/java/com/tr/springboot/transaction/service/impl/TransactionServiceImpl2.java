package com.tr.springboot.transaction.service.impl;

import com.tr.springboot.transaction.service.TransactionService2;
import com.tr.springboot.web.dao.mybatis.TransactionMapper;
import com.tr.springboot.web.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author TR
 * @date 2022/8/22 下午8:00
 */
@Service
public class TransactionServiceImpl2 implements TransactionService2 {

    @Autowired
    TransactionMapper transactionMapper;

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

}
