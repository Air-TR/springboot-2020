package com.tr.springboot.web.dao.jpa;

import com.tr.springboot.web.entity.shiro.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface RoleJpa extends JpaRepository<Role, Integer> {

    @Query(value = "select role from role where role_id in (select role_id from user_role where user_id = :userId)", nativeQuery = true)
    Set<String> selectRolesByUserId(Integer userId);

    @Query(value = "select * from role where role_id in (select role_id from user_role where user_id = :userId)", nativeQuery = true)
    List<Role> findAllByUserId(Integer userId);

//    @Query(value = "select Role from Role where roleId in (select roleId from UserRole where userId = :userId)") // 失败
//    @Query(value = "select r from Role r where r.roleId in (select roleId from UserRole where userId = :userId)") // 成功
    @Query(value = "from Role where roleId in (select roleId from UserRole where userId = :userId)") // 成功
    List<Role> findAllByUserId2(Integer userId);

}
