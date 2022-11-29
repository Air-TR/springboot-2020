package com.tr.springboot.interview.huawei;

import java.util.Scanner;

/**
 * 密码截取：
 *  Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，
 *  但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214。
 *  因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），
 *  Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 *
 * 输入：一个字符串
 * 输出：有效密码串的最大长度
 *
 * @author TR
 * @date 2022/9/21 上午11:12
 */
public class Test32 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            // ABA 型
            int len1 = longest(s, i, i);
            // ABBA 型
            int len2 = longest(s, i, i + 1);
            res = Math.max(res, len1 > len2 ? len1 : len2);
        }
        return res;
    }

    private static int longest(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

}
