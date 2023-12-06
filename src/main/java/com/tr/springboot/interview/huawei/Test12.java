package com.tr.springboot.interview.huawei;

import java.util.Scanner;

/**
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。
 *
 * 输入：ABCD
 * 输出：DCBA
 *
 * @Author TR
 * @date 2022/9/15 上午9:05
 */
public class Test12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder(scanner.nextLine());
        System.out.println(stringBuilder.reverse());
    }

}
