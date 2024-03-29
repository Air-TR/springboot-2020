package com.tr.springboot.shiro.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author TR
 * @date 2022/7/6 上午11:36
 */
@Component
@ConfigurationProperties(prefix = "shiro")
public class ShiroProperties {

    private Boolean filterEnable;

    private String hashAlgorithmName;

    private Integer hashIterations;

    private String salt;

    public Boolean getFilterEnable() {
        return filterEnable;
    }

    public void setFilterEnable(Boolean filterEnable) {
        this.filterEnable = filterEnable;
    }

    public String getHashAlgorithmName() {
        return hashAlgorithmName;
    }

    public void setHashAlgorithmName(String hashAlgorithmName) {
        this.hashAlgorithmName = hashAlgorithmName;
    }

    public Integer getHashIterations() {
        return hashIterations;
    }

    public void setHashIterations(Integer hashIterations) {
        this.hashIterations = hashIterations;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

}
