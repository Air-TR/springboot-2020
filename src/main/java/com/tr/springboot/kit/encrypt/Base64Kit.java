package com.tr.springboot.kit.encrypt;

import java.util.Base64;

/**
 * Base64 工具类
 *
 * @author rtao
 * @date 2022/1/6 10:56
 */
public class Base64Kit {

    public static void main(String[] args) {
        String password = "111111";
        String ciphertext = encode(password);
        System.out.println("密文：" + ciphertext);

        String text = decode(ciphertext);
        System.out.println("明文：" + text);
    }

    /**
     * base64 加密
     * @param string
     * @return 密文
     */
    public static String encode(String string) {
        return Base64.getEncoder().encodeToString(string.getBytes());
    }

    /**
     * base64 解密
     * @param string
     * @return 明文
     */
    public static String decode(String string) {
        return new String(Base64.getDecoder().decode(string.getBytes()));
    }

}
