package com.tr.springboot.web.dao.jpa;

import com.tr.springboot.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
