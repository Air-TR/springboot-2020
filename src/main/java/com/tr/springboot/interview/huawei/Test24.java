package com.tr.springboot.interview.huawei;

import java.util.Scanner;

/**
 * 合唱队（复杂）
 * 原题链接：https://www.nowcoder.com/exam/oj/ta?tpId=37 --> HJ24
 *
 * 注意：不允许改变队列元素的先后顺序，且不要求最高同学左右人数必须相等。
 *
 * 输入描述：用例两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开
 * 输出描述：最少需要几位同学出列
 *
 * 输入：
 *  8
 *  186 186 150 200 160 130 197 200
 * 输出：
 *  4
 * 说明：
 *  由于不允许改变队列元素的先后顺序，所以最终剩下的队列应该为 186 200 160 130 或 150 200 160 130
 *
 * @Author TR
 * @date 2022/9/15 下午4:59
 */
public class Test24 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] left = new int[n];    // 存储每个数左边小于其的数的个数
            int[] right = new int[n];   // 存储每个数右边小于其的数的个数
            left[0] = 1;                // 最左边的数设为1
            right[n - 1] = 1;           // 最右边的数设为1

            // 计算每个位置左侧的最长递增
            for (int i = 0; i < n; i++) {
                left[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) { // 动态规划
                        left[i] = Math.max(left[j] + 1, left[i]);
                    }
                }
            }

            // 计算每个位置右侧的最长递减
            for (int i = n - 1; i >= 0; i--) {
                right[i] = 1;
                for (int j = n - 1; j > i; j--) {
                    if (arr[i] > arr[j]) { // 动态规划
                        right[i] = Math.max(right[i], right[j] + 1);
                    }
                }
            }

            // 记录每个位置的值
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                // 位置 i 计算了两次，所以需要 -1
                result[i] = left[i] + right[i] - 1; // 两个都包含本身
            }

            // 找到最大的满足要求的值
            int max = 1;
            for (int i = 0; i < n; i++) {
                max = Math.max(result[i], max);
            }

            System.out.println(n - max);
        }
    }

}
