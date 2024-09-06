package com.tr.springboot.jasypt;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * 对配置信息加密
 *
 * @Author TR
 * @date 2022/6/29 下午2:37
 */
public class JasyptCreate {

    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

        // 密钥
        textEncryptor.setPassword("SecretKey-R001");

        // 要加密的数据（数据库的用户名或密码）
//        String url = textEncryptor.encrypt("jdbc:mysql://192.168.0.24:3307/school0423?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&useSSL=true");
//        String username = textEncryptor.encrypt("root");
//        String password = textEncryptor.encrypt("123456");
//
//        // 同一数据加密多次，结果也不一样
//        System.out.println("url: " + url);
//        System.out.println("username: " + username);
//        System.out.println("password: " + password);

        System.out.println(textEncryptor.decrypt("Ykls+ESKAyVuYPOqx685Pm/uxzkly14Zt2fIq/CS2yDXDqU9e7OgnyEWk2bkFalDZZxg5Yh7dUZoN0r5A8OoXB+M01Fn2apZbMgIUdOBUWfamWCNf14jEaPei2THv8VcCNYeRbDvVpeibE4oNodwsqLcarlXC+2rJxtKtaiSgtrElgnJs3x07Q=="));
        System.out.println(textEncryptor.decrypt("NZFF9cs63nRnAdlRFa66pA=="));
        System.out.println(textEncryptor.decrypt("QmC7h5KCv4CJi9PT56L+7g=="));

    }

}
