package com.tr.springboot.interview.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 *
 * 示例：
 *  输入：0xAA（0x 开头表示十六进制数据）
 *  输出：170
 *  输入：1A0A（等同于 0x1A0A）
 *  输出：6666
 *
 * @author TR
 * @date 2022/9/14 下午6:09
 */
public class Test5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.startsWith("0x")) {
            System.out.println(Integer.parseInt(str.substring(2), 16));
        } else {
            System.out.println(Integer.parseInt(str, 16));
        }
    }

}
