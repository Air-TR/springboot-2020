package com.tr.springboot.interview.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *  如，输入：Type 输出：epTy
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *  如，输入：BabA 输出：aABb
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *  如，输入：By?e 输出：Be?y
 *
 * 测试：
 *  输入：A Famous Saying: Much Ado About Nothing (2012/8).
 *  输出：A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 *
 * @author TR
 * @date 2022/9/15 下午5:19
 */
public class Test26 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            System.out.println(sort(str));
        }
    }

    public static String sort(String str) {
        // 先将英文字母收集起来
        List<Character> letters = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                letters.add(ch);
            }
        }

        // 将英文字母先排序好
        letters.sort(Comparator.comparingInt(Character::toLowerCase)); // 此行代码为下面注释代码的 lambda 表达式版
//        letters.sort(new Comparator<Character>() {
//            public int compare(Character o1, Character o2) {
//                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
//            }
//        });

        // 若是非英文字母则直接添加
        StringBuilder result = new StringBuilder();
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                result.append(letters.get(j++));
            }
            else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

}
