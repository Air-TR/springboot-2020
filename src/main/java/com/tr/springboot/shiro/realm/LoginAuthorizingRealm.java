package com.tr.springboot.shiro.realm;

import com.tr.springboot.shiro.properties.ShiroProperties;
import com.tr.springboot.web.dao.jpa.*;
import com.tr.springboot.web.entity.shiro.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Set;

/**
 * @author TR
 * @date 2022/7/6 上午11:37
 */
public class LoginAuthorizingRealm extends AuthorizingRealm {

    @Resource
    ShiroProperties shiroProperties;

    @Resource
    UserJpa userJpa;

    @Resource
    UserRoleJpa userRoleJpa;

    @Resource
    RoleJpa roleJpa;

    @Resource
    RolePermJpa rolePermJpa;

    @Resource
    PermJpa permJpa;

    /**
     * 实现用户的登录行为
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 这里强转的类型不一定要是 UsernamePasswordToken，具体要看你在登录接口中所传的对象类型
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        if (!StringUtils.hasText(username)) {
            throw new AccountException("用户名不能为空");
        }
        // 判断用户是否存在（实际业务操作中，这里是去数据库查询用户数据，用 user 对象去判断，而不是 password String 来判断）
        User user = userJpa.findByUsername(username);
        if (Objects.isNull(user)) {
            throw new UnknownAccountException("用户不存在");
        }
        // 这里传入的是用户正确的用户名和密码，shiro 拿正确的用户名密码去和传入的用户名密码参数做校验
        ByteSource salt = ByteSource.Util.bytes(shiroProperties.getSalt());
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, user.getPassword(), salt, getName());
        return simpleAuthenticationInfo;
    }

    /**
     * 返回用户的角色权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 根据 username 获取用户的 role 和 permission 进行赋值
        String username = (String) getAvailablePrincipal(principalCollection);
        User user = userJpa.findByUsername(username);

        /** 角色（获取 roles 完整流程）*/
//        List<UserRole> userRoleList = userRoleJpa.findAllByUserId(user.getUserId());
//        List<Integer> roleIds = userRoleList.stream().map(userRole -> userRole.getRoleId()).collect(Collectors.toList());
//        List<Role> roleList = roleJpa.findAllById(roleIds);
//        Set<String> roles = roleList.stream().map(role -> role.getRole()).collect(Collectors.toSet());
        /** 权限（获取 perms 完整流程）*/
//        List<RolePerm> rolePermList = rolePermJpa.findAllByRoleIdIn(roleIds);
//        List<Integer> permIds = rolePermList.stream().map(rolePerm -> rolePerm.getPermId()).collect(Collectors.toList());
//        List<Perm> permList = permJpa.findAllById(permIds);
//        Set<String> perms = permList.stream().map(perm -> perm.getPerm()).collect(Collectors.toSet());

        /** 角色（获取 roles 精简流程）*/
//        List<Role> roleList = roleJpa.findAllByUserId(user.getUserId());
//        Set<String> roles = roleList.stream().map(role -> role.getRole()).collect(Collectors.toSet());
        /** 权限（获取 perms 精简流程）*/
//        List<Perm> permList = permJpa.findAllByUserId(user.getUserId());
//        Set<String> perms = permList.stream().map(perm -> perm.getPerm()).collect(Collectors.toSet());

        /** 角色（获取 roles 最简流程）*/
        Set<String> roles = roleJpa.selectRolesByUserId(user.getUserId());
        /** 权限（获取 perms 最简流程）*/
        Set<String> perms = permJpa.selectPermsByUserId(user.getUserId());

        // 角色（手动模拟赋值）
//        Set<String> roles = new HashSet<>();
//        if ("admin".equals(username)) {
//            roles.add("Admin");
//            roles.add("System");
//            roles.add("Visitor");
//        }
//        if ("system".equals(username)) {
//            roles.add("System");
//            roles.add("Visitor");
//        }
//        if ("visitor".equals(username)) {
//            roles.add("Visitor");
//        }
        // 权限（手动模拟赋值）
//        Set<String> perms = new HashSet<>();
//        if (roles.contains("Admin")) {
//            perms.add("admin:*");
//        }
//        if (roles.contains("System")) {
//            perms.add("system:*");
//        }
//        if (roles.contains("Visitor")) {
//            perms.add("visitor:*");
//        }

        // 为当前用户添加角色和权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(perms);
        return info;
    }

}
