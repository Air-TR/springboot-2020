package com.tr.springboot.web.entity.shiro;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * userId + roleId 联合主键
 *
 * @Author TR
 * @date 2022/7/8 下午2:20
 */
@Entity
@IdClass(UserRole.class)
public class UserRole implements Serializable {

    @Id
    private Integer userId;

    @Id
    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
