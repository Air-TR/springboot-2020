package com.tr.springboot.util.encrypt;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA 工具类
 *
 * @author rtao
 * @date 2022/1/7 11:05
 */
public class RSAUtil {

    /** 用于封装随机产生的公钥与私钥 */
    private final static Map<String, String> keyMap = new HashMap<>();
    private final static String PUBLIC_KEY = "PUBLIC_KEY";
    private final static String PRIVATE_KEY = "PRIVATE_KEY";

    public static void main(String[] args) throws Exception {
        // 生成公钥和私钥
        genKeyPair();

        String message = "abc+123456";
        System.out.println("随机生成的公钥长度为: " + keyMap.get(PUBLIC_KEY).length());
        System.out.println("随机生成的公钥为: " + keyMap.get(PUBLIC_KEY));
        System.out.println("随机生成的私钥长度为: " + keyMap.get(PRIVATE_KEY).length());
        System.out.println("随机生成的私钥为: " + keyMap.get(PRIVATE_KEY));
        String messageEn = encrypt(message, keyMap.get(PUBLIC_KEY));
        System.out.println("加密后的字符串为: " + messageEn);
        String messageDe = decrypt(messageEn, keyMap.get(PRIVATE_KEY));
        System.out.println("还原后的字符串为: " + messageDe);
    }

    /**
     * 随机生成密钥对
     *
     * @throws NoSuchAlgorithmException
     */
    public static void genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(1024, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        // 得到公钥字符串
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        // 将公钥和私钥保存到Map
        keyMap.put(PUBLIC_KEY, publicKeyString);
        keyMap.put(PRIVATE_KEY, privateKeyString);
    }

    /**
     * RSA公钥加密
     *
     * @param string    加密字符串
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public static String encrypt(String string, String publicKey) throws Exception {
        // base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        // RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String ciphertext = Base64.encodeBase64String(cipher.doFinal(string.getBytes("UTF-8")));
        return ciphertext;
    }

    /**
     * RSA私钥解密
     *
     * @param string     加密字符串
     * @param privateKey 私钥
     * @return 明文
     * @throws Exception 解密过程中的异常信息
     */
    public static String decrypt(String string, String privateKey) throws Exception {
        // 64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(string.getBytes("UTF-8"));
        // base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        // RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String cleartext = new String(cipher.doFinal(inputByte));
        return cleartext;
    }

}
