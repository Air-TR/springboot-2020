package com.tr.springboot.interview.huawei;

import java.util.Random;
import java.util.Scanner;

/**
 * 蛇形矩阵是由 1 开始的自然数依次排列成的一个矩阵上三角形。
 * 例如，当输入 5 时，应该输出的三角形为：
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 *
 * 输入：正整数 N
 * 输出：一个 N 行的蛇形矩阵
 *
 * @Author TR
 * @date 2022/9/21 上午11:45
 */
public class Test35 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt(); // 读入正整数 n
            int[][] result = new int[n][]; // 建立数组（n 行）
            int t = 1; // 记录依次赋予的数组值
            for (int i = 0; i < n; i++) {
                result[i] = new int[n - i]; // 数组第 i 行有 n-i 个元素
                for (int j = 0; j < i + 1; j++) { // 对第 i 个对角线赋值
                    result[i - j][j] = t;
                    t++;
                }
            }

            // 输出数组值
            for (int[] a : result) {
                for (int a1 : a) {
                    System.out.print(a1 + " ");
                }
                System.out.println();
            }
        }
    }

}
