package com.tr.springboot.interview.huawei;

import java.util.Scanner;

/**
 * 输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如 180 的质因子为 2 2 3 3 5）
 *
 * 测试时输入：2000000014
 * 结果应为：2 1000000007
 *
 * 但是！此题有时间复杂度限制，要求程序在 1s 内执行完成。
 *
 * @author TR
 * @date 2022/9/14 下午6:15
 */
public class Test6 {

    /**
     * 测试 2000000014 符合执行时间 1s 内要求。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        long k = (long) Math.sqrt(num);
        for (long i = 2; i <= k; ++i) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println(num == 1 ? "" : num + " ");
    }

    /**
     * 测试 2000000014 不符合执行时间 1s 内要求。
     */
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        long num = scanner.nextLong();
//        for (long i = 2; i <= num; ++i) {
//            while (num % i == 0) {
//                System.out.print(i + " ");
//                num /= i;
//            }
//        }
//        System.out.println();
//    }

}
