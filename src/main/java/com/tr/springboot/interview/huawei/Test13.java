package com.tr.springboot.interview.huawei;

import java.util.Scanner;

/**
 * 将一个英文语句以单词为单位逆序排放。例如 "I am a boy"，逆序排放后为 "boy a am I"。
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符。
 *
 * @author TR
 * @date 2022/9/15 上午9:07
 */
public class Test13 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] arr = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i > 0) {
                stringBuilder.append(arr[i]).append(" ");
            }
            if (i == 0) {
                stringBuilder.append(arr[i]);
            }
        }
        System.out.println(stringBuilder);
    }

}
