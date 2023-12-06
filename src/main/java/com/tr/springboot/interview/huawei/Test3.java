package com.tr.springboot.interview.huawei;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 生成了 N 个1到500之间的随机整数。要求删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
 *
 * 输入描述：
 *  第一行先输入随机整数的个数 N。接下来的 N 行每行输入一个整数，代表生成的随机数。
 * 输出描述：
 *  输出多行，表示输入数据处理后的结果。
 *
 * @Author TR
 * @date 2022/9/14 下午5:25
 */
public class Test3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 获取个数
        int num = sc.nextInt();
        // 创建 TreeSet 进行去重，并排序！
        TreeSet set = new TreeSet();
        // 输入
        for(int i = 0 ; i < num ; i++){
            set.add(sc.nextInt());
        }
        // 输出
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
