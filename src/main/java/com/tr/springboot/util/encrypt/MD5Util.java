package com.tr.springboot.util.encrypt;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * MD5 工具类
 *  MD5 具有不可逆性
 *
 * @author rtao
 * @date 2022/1/6 10:48
 */
public class MD5Util {

    public static void main(String[] args) {
        String password = "123456";
        System.out.println("MD5 加密不带盐：" + md5(password));
        System.out.println("MD5 加密，带盐：" + md5WithSalt(password, SALT));
    }

    private static final String SALT = "salt";

    /**
     * Md5 加密，不带盐
     *
     * @param string
     * @return
     */
    public static String md5(String string) {
        return new Md5Hash(string).toString();
    }

    /**
     * Md5 加密，带盐
     *
     * @param string
     * @param salt
     * @return
     */
    public static String md5WithSalt(String string, String salt) {
        return new Md5Hash(string, salt).toString();
    }

}