package com.tr.springboot.interview.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 将字符串中字符按 ASCII 码值排序
 *
 * 输入：Ihave1nose2hands10fingers
 * 输出：0112Iaadeeefghhinnnorsssv
 *
 * @author TR
 * @date 2022/9/21 上午11:38
 */
public class Test34 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        System.out.println(arr);
    }

}
