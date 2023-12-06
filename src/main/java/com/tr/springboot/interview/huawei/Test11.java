package com.tr.springboot.interview.huawei;

import java.util.Scanner;

/**
 * 输入一个整数，将这个整数以字符串的形式逆序输出。
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001。
 *
 * @Author TR
 * @date 2022/9/15 上午9:02
 */
public class Test11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder(scanner.nextLine());
        System.out.println(stringBuilder.reverse());
    }

}
