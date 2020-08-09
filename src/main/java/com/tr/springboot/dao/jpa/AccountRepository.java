package com.tr.springboot.dao.jpa;

import com.tr.springboot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository  extends JpaRepository<Account, Integer> {
}
