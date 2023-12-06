package com.tr.springboot.recursion;

/**
 * @Author: TR
 */
public class Recursion {

    public static void main(String[] args) {
        System.out.println(plus(0));      // 输出 5，符合预期
        System.out.println(plusWrong(0)); // 输出 1，不符合预期
    }

    private static int plus(int i) {
        if (i >= 5) {
            return i;
        }
        i++;
        return plus(i);
    }

    private static int plusWrong(int i) {
        if (i < 5) {
            i++;
            plus(i);
        }
        return i;
    }

}
