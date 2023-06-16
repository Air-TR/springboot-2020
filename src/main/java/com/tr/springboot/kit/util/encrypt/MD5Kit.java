package com.tr.springboot.kit.util.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 此工具类不依赖于 shiro，MD5Util 依赖 shiro
 *
 * @Author: TR
 * @Date: 2023/6/1
 */
public class MD5Kit {

    public static String encrypt(String plainText) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(plainText.getBytes());
        byte[] encryptedBytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : encryptedBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
