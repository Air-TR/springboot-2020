package com.tr.springboot.interview.huawei;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于 0.5，向上取整；小于 0.5，则向下取整。
 * 数据范围：保证输入的数字在 32 位浮点数范围内。
 *
 * 输入描述：
 *  输入一个正浮点数值
 * 输出描述：
 *  输出该数值的近似整数值
 *
 * @Author TR
 * @date 2022/9/14 下午6:33
 */
public class Test7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float number = sc.nextFloat();
        System.out.println((int)(number + 0.5));
    }

}
