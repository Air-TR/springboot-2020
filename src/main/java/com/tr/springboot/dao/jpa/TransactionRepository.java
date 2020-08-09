package com.tr.springboot.dao.jpa;

import com.tr.springboot.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository 传入对象和对象Id的类型作为参数
 * 没有必要将@Repository注释放在扩展的接口上JpaRepository；Spring通过扩展预定义Repository接口之一来识别存储库。
 * JpaRepository中 @NoRepositoryBean 注释的目的是防止Spring将该特定接口本身视为存储库。
 */
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
