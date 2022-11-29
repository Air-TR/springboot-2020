package com.tr.springboot.interview.huawei;

import java.util.Scanner;

/**
 * IP 地址与数字的转换
 *  原理：ip 地址的每段可以看成是一个 0-255 的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成一个长整数。
 *  举例：一个 ip 地址为 10.0.3.193
 *  每段数字             相对应的二进制数
 *  10                   00001010
 *  0                    00000000
 *  3                    00000011
 *  193                  11000001
 *  组合起来即为：00001010 00000000 00000011 11000001，转换为 10 进制数就是：167773121。
 *
 * 输入：10.0.3.193
 * 输出：167773121
 *
 * 输入：167969729
 * 输出：10.3.3.193
 *
 * @author TR
 * @date 2022/9/21 上午11:29
 */
public class Test33 {

    private static final int N = 4;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            System.out.println(convert(str));
        }
    }

    public static String convert(String str) {
        // ipv4 -> int
        if (str.contains(".")) {
            String[] fields = str.split("\\.");
            long result = 0;
            for (int i = 0; i < N; i++) {
                result = result * 256 + Integer.parseInt(fields[i]);
            }
            return "" + result;
        }
        // int -> ipv4
        else {
            long ipv4 = Long.parseLong(str);
            String result = "";
            for (int i = 0; i < N; i++) {
                result = ipv4 % 256 + "." + result;
                ipv4 /= 256;
            }
            return result.substring(0, result.length() - 1);
        }
    }

}
