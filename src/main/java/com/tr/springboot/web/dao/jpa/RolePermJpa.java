package com.tr.springboot.web.dao.jpa;

import com.tr.springboot.web.entity.shiro.RolePerm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolePermJpa extends JpaRepository<RolePerm, Integer> {

    List<RolePerm> findAllByRoleIdIn(List<Integer> roleIds);

}
