package com.tr.springboot.jasypt;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * 对配置信息加密
 *
 * @author TR
 * @date 2022/6/29 下午2:37
 */
public class JasyptCreate {

    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        // 密钥
        textEncryptor.setPassword("Orion123456");
        // 要加密的数据（数据库的用户名或密码）
        String url = textEncryptor.encrypt("jdbc:mysql://192.168.3.10:3306/orion?serverTimezone=Asia/Shanghai");
        String username = textEncryptor.encrypt("user");
        String password = textEncryptor.encrypt("HBxy_123456@8717$aliy");
        // 同一数据加密多次，结果也不一样
        System.out.println("url: " + url); // HlFACI4CbfMzdKyf62F+G/9SCi5EsfneQnLjMRaRSeduPSh1dWa9QxtT7XmzZdXA3fioAQ5pU1FIQf4B9FPYISFn2xOeCWLmDkdUcE4jYgPWpoy6MCLam7Iw97xX77ZxkiTHQV2SE9M=
        System.out.println("username: " + username); // 6YrBrC3DIPDhLs6pDblobg==
        System.out.println("password: " + password); // ZtkRoI6NnmHAhN8USO1DDA==
    }

    /**
     * Mac本地（密钥：SecretKey）
     *  jdbc:mysql://127.0.0.1:3306/springboot-2020?useUnicode=true&characterEncoding=utf-8&useSSL=true
     *  root & root
     */

    /**
     * orion-3.10（密钥：Orion123456）
     *  jdbc:mysql://192.168.3.10:3306/orion?serverTimezone=Asia/Shanghai
     *  user & HBxy_123456@8717$aliy
     */

}
