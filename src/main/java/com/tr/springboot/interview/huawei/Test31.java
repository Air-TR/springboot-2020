package com.tr.springboot.interview.huawei;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 对字符串中的所有单词进行倒排。
 * 说明：
 *  1、构成单词的字符只有 26 个大写或小写英文字母；
 *  2、非构成单词的字符均视为单词间隔符；
 *  3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 *  4、每个单词最长20个字母；
 *
 * 输入：I am a student
 * 输出：student a am I
 *
 * 输入：$bo*y gi!r#l
 * 输出：l r gi y bo
 *
 * @Author TR
 * @date 2022/9/15 下午10:31
 */
public class Test31 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            /**
             * 正则里的 + 很重要！没有 '+' 不符合第 3 条，会出现相邻单词间有多个空格符。
             * 如测试：
             *  090 jou090 jj0
             *  feaf * afaefeafeafwafaefeafawf
             */
            String[] arr = str.split("[^a-zA-Z]+");
            StringBuilder builder = new StringBuilder();
            for (int i = arr.length - 1; i >= 0; i--) {
                builder.append(arr[i]).append(" ");
            }
            System.out.println(builder.toString().trim());
        }
    }

}
