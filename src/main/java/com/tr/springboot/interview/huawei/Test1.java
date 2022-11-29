package com.tr.springboot.interview.huawei;

import java.util.Scanner;

/**
 * 计算字符串最后一个单词的长度，单词以空格隔。（注：字符串末尾不以空格为结尾）
 *
 * 示例：
 *  输入：hello nowcoder
 *  输出：8
 *  说明：最后一个单词为 nowcoder，长度为 8
 *
 * @author TR
 * @date 2022/9/14 下午4:44
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // 解法 1
        String[] arr = str.split(" "); // 正则表达式实用性更强( str.split("\\s+"))
        int length1 = arr[arr.length - 1].length();
        System.out.println(length1);

        // 解法 2
        int length2 = str.substring(str.lastIndexOf(" ") + 1).length();
        System.out.println(length2);
    }

}
