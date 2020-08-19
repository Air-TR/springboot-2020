package com.tr.springboot.web.dao.jpa;

import com.tr.springboot.web.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
