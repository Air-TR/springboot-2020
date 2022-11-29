package com.tr.springboot.interview.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
 * 现在给定你 n 个单词，另外再给你一个单词 x ，让你寻找 x 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
 *
 * 输入描述：输入只有一行。先输入字典中单词的个数 n，再输入 n 个单词作为字典单词。 然后输入一个单词 x，最后后输入一个整数 k。
 * 输出描述：第一行输出查找到 x 的兄弟单词的个数 m，第二行输出查找到的按照字典顺序排序后的第 k 个兄弟单词，没有符合第 k 个的话则不用输出。
 *
 * 示例1：
 *  输入：
 *      3 abc bca cab abc 1
 *  输出：
 *      2
 *      bca
 *
 * 示例2：
 *  输入：
 *      6 cab ad abcd cba abc bca abc 1
 *  输出：
 *      3
 *      bca
 *
 * @author TR
 * @date 2022/9/15 下午5:29
 */
public class Test27 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] arr = scanner.nextLine().split(" ");
            Integer n = Integer.parseInt(arr[0]);
            String x = arr[arr.length - 2];
            Integer k = Integer.parseInt(arr[arr.length - 1]);
            List<String> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (isBrother(x, arr[i])) {
                    list.add(arr[i]);
                }
            }
            int size = list.size();
            System.out.println(size);
            if (size >= k) {
                Collections.sort(list);
                System.out.println(list.get(k - 1));
            }
        }
    }

    public static boolean isBrother(String x, String y) {
        if (x.length() != y.length() || y.equals(x)) {
            return false;
        }
        char[] s = x.toCharArray();
        char[] j = y.toCharArray();
        Arrays.sort(s);
        Arrays.sort(j);
        return new String(s).equals(new String(j));
    }

}
