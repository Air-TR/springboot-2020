package com.tr.springboot.interview.huawei;

import java.util.Scanner;

/**
 * 某商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
 * 现有有 n 个空汽水瓶，最多可以喝到多少瓶汽水。
 *
 * 注意：本题存在多组输入。输入的 0 表示输入结束，对 0 不用输出结果。
 *
 * 解题思路：2 个空瓶 + 借 1 瓶，喝完把喝的那瓶还给老板，正好。所以，结果就是 n / 2。
 *
 * @author TR
 * @date 2022/9/15 下午2:55
 */
public class Test22 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int bottle = sc.nextInt();
            if (bottle == 0) {
                break;
            }
            System.out.println(bottle / 2);
        }
    }

}
