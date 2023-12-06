package com.tr.springboot.interview.huawei;

import java.util.Scanner;

/**
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 * 数据范围：保证在 32 位整型数字范围内。
 *
 * 输入描述：
 *  输入一个整数（int类型）
 * 输出描述：
 *  这个数转换成二进制后，输出 1 的个数
 *
 * @Author TR
 * @date 2022/9/15 上午9:42
 */
public class Test15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        /**
         * 十进制 转 二进制：Integer.toBinaryString(num);
         * 十进制 转 八进制：Integer.toOctalString(num);
         * 十进制 转 十六进制：Integer.toHexString(num);
         */
        String str = Integer.toBinaryString(num);
        System.out.println(str.replaceAll("0", "").length());
    }

}
