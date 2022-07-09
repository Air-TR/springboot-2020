package com.tr.springboot.web.entity.shiro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author TR
 * @date 2022/7/8 下午2:20
 */
@Entity
public class Perm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer permId;

    private String perm;

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }
}
