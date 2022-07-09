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
        String username = textEncryptor.encrypt("root");
        String password = textEncryptor.encrypt("root");
        // 同一数据加密多次，结果也不一样
        System.out.println("username: " + username); // 6YrBrC3DIPDhLs6pDblobg==
        System.out.println("password: " + password); // ZtkRoI6NnmHAhN8USO1DDA==
    }

}
