package com.tr.springboot.web.entity.shiro;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * roleId + permId 联合主键
 *  注：使用联合主键，bean类必须序列化
 *
 * @author TR
 * @date 2022/7/8 下午2:20
 */
@Entity
@IdClass(RolePerm.class)
public class RolePerm implements Serializable {

    @Id
    private Integer roleId;

    @Id
    private Integer permId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }
}
