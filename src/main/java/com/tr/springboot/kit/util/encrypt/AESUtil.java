package com.tr.springboot.kit.util.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * @Author: TR
 * @Date: 2023/6/1
 */
public class AESUtil {

    public static void main(String[] args) throws Exception {
        String plainText = "Hello World";
        String key = "877f06335bce47d8";
        String encryptedText = encrypt(plainText, key);
        String decryptedText = decrypt(encryptedText, key);
        System.out.println("密文: " + encryptedText);
        System.out.println("明文: " + decryptedText);
    }

    private static final String AES_ALGORITHM = "AES/ECB/PKCS5Padding";

    public static String encrypt(String plainText, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedText, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }

}
