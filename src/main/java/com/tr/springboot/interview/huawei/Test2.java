package com.tr.springboot.interview.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 *
 * @author TR
 * @date 2022/9/14 下午5:08
 */
public class Test2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();
        String s = br.readLine().toLowerCase();
        System.out.println(str.length() - str.replaceAll(s, "").length());
    }

}
