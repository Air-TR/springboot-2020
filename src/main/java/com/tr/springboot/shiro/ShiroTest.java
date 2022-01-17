package com.tr.springboot.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.jupiter.api.Test;

/**
 * 原生 shiro 测试类
 *
 * @author rtao
 * @date 2022/1/17 16:05
 */
@Slf4j
public class ShiroTest {

    @Test
    public void loginTest() {
        // 创建IniSecurityManager工程对象:加载配置文件
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 通过工厂对象创建SecurityManager对象
        SecurityManager securityManager = factory.getInstance();
        // 将SecurityManager绑定到当前运行环境中，让系统随时可以访问SecurityManager对象
        SecurityUtils.setSecurityManager(securityManager);

        // 创建登录主体 注意：此时主体没有经过验证，仅仅是个空的对象
        Subject subject = SecurityUtils.getSubject();
        // 绑定主体登陆的身份、凭证 即账号密码
        UsernamePasswordToken token = new UsernamePasswordToken("james", "666");
        // 主体登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            log.error("用户名不存在！", e.getMessage());
        } catch (AuthenticationException e) {
            log.error("账号或密码错误！", e.getMessage());
        } catch (AuthorizationException e) {
            log.error("没有权限！", e.getMessage());
        }
        // 登陆判断
        System.out.println("登录结果" + subject.isAuthenticated());
        // 登出判断
        subject.logout();
        System.out.println("登出结果" + subject.isAuthenticated());
    }

}
