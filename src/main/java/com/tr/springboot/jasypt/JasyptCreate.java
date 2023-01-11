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
        textEncryptor.setPassword("SecretKey");
        // 要加密的数据（数据库的用户名或密码）
        String url = textEncryptor.encrypt("jdbc:mysql://127.0.0.1:3306/springboot-2020?useUnicode=true&characterEncoding=utf-8&useSSL=true");
        String username = textEncryptor.encrypt("root");
        String password = textEncryptor.encrypt("root");
        // 同一数据加密多次，结果也不一样
        System.out.println("url: " + url); // HlFACI4CbfMzdKyf62F+G/9SCi5EsfneQnLjMRaRSeduPSh1dWa9QxtT7XmzZdXA3fioAQ5pU1FIQf4B9FPYISFn2xOeCWLmDkdUcE4jYgPWpoy6MCLam7Iw97xX77ZxkiTHQV2SE9M=
        System.out.println("username: " + username); // 6YrBrC3DIPDhLs6pDblobg==
        System.out.println("password: " + password); // ZtkRoI6NnmHAhN8USO1DDA==
    }

}
