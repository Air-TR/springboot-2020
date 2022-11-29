package com.tr.springboot.interview.huawei;

import java.util.Scanner;

/**
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。（输入的整数最后一位不是 0）
 *
 * 示例1
 *  输入：9876673
 *  输出：37689
 *
 * @author TR
 * @date 2022/9/14 下午6:50
 */
public class Test9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder(scanner.nextLine()).reverse();
        String str = stringBuilder.toString();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) { // 只有这个字符是第一次出现才拿到结果去
                result.append(str.charAt(i));
            }
        }
        System.out.println(result.toString());
    }

}
