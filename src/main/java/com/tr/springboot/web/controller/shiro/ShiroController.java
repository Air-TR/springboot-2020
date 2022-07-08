package com.tr.springboot.web.controller.shiro;

import com.tr.springboot.shiro.properties.ShiroProperties;
import com.tr.springboot.web.dao.jpa.UserJpa;
import com.tr.springboot.web.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author TR
 * @date 2022/7/6 上午11:39
 */
@RestController
public class ShiroController {

    @Resource
    ShiroProperties shiroProperties;

    @Resource
    UserJpa userJpa;

    @GetMapping("/register/{username}/{password}")
    public String register(@PathVariable String username, @PathVariable String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(encryptPassword(password));
        user.setPasswordText(password);
        userJpa.save(user);
        return "注册成功，跳转登录页...";
    }

    @GetMapping("/login/{username}/{password}")
    public String login(@PathVariable String username, @PathVariable String password) {
        // 获取主体
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, password));
        } catch (UnknownAccountException e) {
            return "UnknownAccountException: " + e.getMessage();
        } catch (AccountException e) {
            return "AccountException: " + e.getMessage();
        } catch (IncorrectCredentialsException e) {
            return "IncorrectCredentialsException: " + e.getMessage();
        }
        return "登陆成功，准备跳转主页";
    }

    @GetMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "登出成功，准备跳转登录页...";
    }

    @GetMapping("/loginPage")
    public String loginPage() {
        return "登录页";
    }

    @GetMapping("/403")
    public String page403() {
        return "403：没有权限，拒绝访问！（通过 ShiroConfig 重定向）";
    }

    @GetMapping("/my403")
    public String pageMy403() {
        return "my403：没有权限，拒绝访问！（经过 ShiroExceptionAdvice 重定向）";
    }

    private String encryptPassword(String password) {
        return new Sha256Hash(password, shiroProperties.getSalt(), shiroProperties.getHashIterations()).toString();
    }

}
