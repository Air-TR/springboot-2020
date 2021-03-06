package com.tr.springboot.web.dao.mybatis;

import com.tr.springboot.web.entity.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionMapper {
    
    int deleteById(Integer id);

    int insert(Transaction record);

    Transaction selectById(Integer id);

    int updateById(Transaction record);
    
}