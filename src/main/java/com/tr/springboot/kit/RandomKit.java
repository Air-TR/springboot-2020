package com.tr.springboot.kit;

import java.util.Random;

/**
 * @Author: TR
 */
public class RandomKit {

    public static void main(String[] args) {
        System.out.println("随机生成的字符串：" + randomCharacter(10));
        System.out.println("随机生成的数字：" + randomNumber(10));
    }

    public static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";

    public static String randomCharacter(int length) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = CHARACTERS.charAt(random.nextInt(CHARACTERS.length()));
            builder.append(c);
        }
        return builder.toString();
    }

    public static String randomNumber(int length) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = NUMBERS.charAt(random.nextInt(NUMBERS.length()));
            builder.append(c);
        }
        return builder.toString();
    }

}
