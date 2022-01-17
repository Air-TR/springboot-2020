package com.tr.springboot.util.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA256 工具类
 *
 * @author rtao
 * @date 2022/1/14 16:47
 */
public class SHA256Util {

    private final static String SHA_256 = "SHA-256";
    private final static String UTF_8 = "UTF-8";

    /**
     * 用 java 原生的摘要实现 SHA256 加密
     *
     * @param string 加密前的报文
     * @return
     */
    public static String getSHA256String(String string) {
        String encodeStr = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SHA_256);
            messageDigest.update(string.getBytes(UTF_8));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    /**
     * byte[]转为16进制
     *
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

}
