package com.tr.springboot.web.dao.jpa;

import com.tr.springboot.web.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountJpa extends JpaRepository<Account, Integer> {

    List<Account> findByBalance(Double balance);

    @Query("select name from Account where balance = ?1")
    List<String> findNameByBalance(Double balance);

    List<Account> findByGender(Integer gneder);

    List<Account> findByGenderAndBalance(Integer gneder, Double balance);
}
