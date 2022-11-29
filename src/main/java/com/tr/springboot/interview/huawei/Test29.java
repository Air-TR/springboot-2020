package com.tr.springboot.interview.huawei;

import java.util.Scanner;

/**
 * 对输入的字符串进行加解密，并输出。
 * 加密方法为：
 *  当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 *  当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 *  其他字符不做变化。
 * 解密方法为加密的逆过程。
 *
 * 输入：
 *  2OA92AptLq5G1lW8564qC4nKMjv8C
 *  B5WWIj56vu72GzRja7j5
 * 输出：
 *  3pb03bQUmR6h2Mx9675Rd5OlnKW9d
 *  a4vvhI45UT61fYqIZ6I4
 *
 * @author TR
 * @date 2022/9/15 下午8:40
 */
public class Test29 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println("encode: " + encode(scanner.nextLine()));
            System.out.println("decode: " + decode(scanner.nextLine()));
        }
    }

    // 加密函数
    private static String encode(String code) {
        char[] t = code.toCharArray();    // 将 String 对象转换为字符数组
        for (int i = 0; i < t.length; i++) {
            if (t[i] >= 'a' && t[i] < 'z')
                t[i] = (char) (t[i] - 'a' + 'A' + 1);
            else if (t[i] == 'z')
                t[i] = 'A';
            else if (t[i] >= 'A' && t[i] < 'Z')
                t[i] = (char) (t[i] - 'A' + 'a' + 1);
            else if (t[i] == 'Z')
                t[i] = 'a';
            else if (t[i] >= '0' && t[i] < '9')
                t[i] = (char) (t[i] + 1);
            else if (t[i] == '9')
                t[i] = '0';
        }
        return String.valueOf(t);
    }

    // 解密函数
    private static String decode(String password) {
        char[] t = password.toCharArray();
        for (int i = 0; i < t.length; i++) {
            if (t[i] > 'a' && t[i] <= 'z')
                t[i] = (char) (t[i] - 'a' + 'A' - 1);
            else if (t[i] == 'a')
                t[i] = 'Z';
            else if (t[i] > 'A' && t[i] <= 'Z')
                t[i] = (char) (t[i] - 'A' + 'a' - 1);
            else if (t[i] == 'A')
                t[i] = 'z';
            else if (t[i] > '0' && t[i] <= '9')
                t[i] = (char) (t[i] - 1);
            else if (t[i] == '0')
                t[i] = '9';
        }
        return String.valueOf(t);
    }

}
