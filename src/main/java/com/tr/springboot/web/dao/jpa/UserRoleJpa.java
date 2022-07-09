package com.tr.springboot.web.dao.jpa;

import com.tr.springboot.web.entity.shiro.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleJpa extends JpaRepository<UserRole, Integer> {

    List<UserRole> findAllByUserId(Integer userId);

}
