package com.tr.springboot.web.dao.jpa;

import com.tr.springboot.web.entity.shiro.Perm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface PermJpa extends JpaRepository<Perm, Integer> {

    @Query(value = "select * from perm where perm_id in (select perm_id from role_perm where role_id in (select role_id from user_role where user_id = :userId))", nativeQuery = true)
    List<Perm> findAllByUserId(Integer userId);

    @Query(value = "select perm from perm where perm_id in (select perm_id from role_perm where role_id in (select role_id from user_role where user_id = :userId))", nativeQuery = true)
    Set<String> selectPermsByUserId(Integer userId);

}
