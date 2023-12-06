package com.tr.springboot.interview.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 素数伴侣（复杂）：
 * 原题链接：https://www.nowcoder.com/exam/oj/ta?tpId=37 --> HJ28
 *
 * 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。现在密码学会请你设计一个程序，
 * 从已有的 N （ N 为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，
 * 例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，
 * 能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。
 *
 * 输入：有一个正偶数 n ，表示待挑选的自然数的个数。后面给出 n 个具体的数字。
 * 输出：输出一个整数 K ，表示你求得的“最佳方案”组成“素数伴侣”的对数。
 *
 * 输入：4
 *      2 5 6 13
 * 输出：2
 *
 * 输入：2
 *      3 6
 * 输出：0
 *
 *
 * @Author TR
 * @date 2022/9/15 下午8:29
 */
public class Test28 {

    static int max = 0;

    public static void main(String[] args) {
        // 标准输入
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 输入正偶数
            int n = sc.nextInt();
            // 用于记录输入的n个整数
            int[] arr = new int[n];
            // 用于存储所有的奇数
            ArrayList<Integer> odds = new ArrayList<>();
            // 用于存储所有的偶数
            ArrayList<Integer> evens = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                // 将奇数添加到 odds
                if (arr[i] % 2 == 1) {
                    odds.add(arr[i]);
                }
                // 将偶数添加到 evens
                if (arr[i] % 2 == 0) {
                    evens.add(arr[i]);
                }
            }
            // 下标对应已经匹配的偶数的下标，值对应这个偶数的伴侣
            int[] matcheven = new int[evens.size()];
            // 记录伴侣的对数
            int count = 0;
            for (int j = 0; j < odds.size(); j++) {
                // 用于标记对应的偶数是否查找过
                boolean[] v = new boolean[evens.size()];
                // 如果匹配上，则计数加 1
                if (find(odds.get(j), matcheven, evens, v)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    // 判断奇数 x 能否找到伴侣
    private static boolean find(int x, int[] matcheven, ArrayList<Integer> evens, boolean[] v) {
        for (int i = 0; i < evens.size(); i++) {
            // 该位置偶数没被访问过，并且能与 x 组成素数伴侣
            if (isPrime(x + evens.get(i)) && v[i] == false) {
                v[i] = true;
                /**
                 * 如果 i 位置偶数还没有伴侣，则与 x 组成伴侣，
                 * 如果已经有伴侣，并且这个伴侣能重新找到新伴侣，则把原来伴侣让给别人，自己与 x 组成伴侣
                 */
                if (matcheven[i] == 0 || find(matcheven[i], matcheven, evens, v)) {
                    matcheven[i] = x;
                    return true;
                }
            }
        }
        return false;
    }

    // 判断 x 是否是素数
    private static boolean isPrime(int x) {
        if (x == 1) return false;
        // 如果能被 2 到根号 x 整除，则一定不是素数
        for (int i = 2; i <= (int) Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

}
