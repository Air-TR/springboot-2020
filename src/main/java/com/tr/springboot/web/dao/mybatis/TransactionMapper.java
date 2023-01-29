package com.tr.springboot.web.dao.mybatis;

import com.tr.springboot.web.entity.Transaction;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionMapper {
    
    int deleteById(Integer id);

    int insert(Transaction record);

    /**
     * 可以使用 @Select 形式代替
     */
//    @Select("select * from transaction where id=#{id}")
    Transaction selectById(Integer id);

    int updateById(Transaction record);
    
}