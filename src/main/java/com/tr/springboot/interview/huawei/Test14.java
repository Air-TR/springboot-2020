package com.tr.springboot.interview.huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 给定 n 个字符串，请对 n 个字符串按照字典序排列。
 *
 * 输入描述：
 *  输入第一行为一个正整数 n，下面 n 行为 n 个字符串，字符串中只含有大小写字母。
 * 输出描述：
 *  数据输出 n 行，输出结果为按照字典序排列的字符串。
 *
 * 示例：
 *  输入：
 *      3
 *      cat
 *      boot
 *      app
 *  输出：
 *      app
 *      boot
 *      cat
 *
 * @Author TR
 * @date 2022/9/15 上午9:19
 */
public class Test14 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.valueOf(br.readLine());
        String[] array = new String[count];
        for (int i = 0; i < count; i++) {
            array[i] = br.readLine(); // BufferedReader 使用 readLine() 不会少接收一个字符串，运行结果正常。
        }
        Arrays.sort(array);
        for (String str : array) {
            System.out.println(str);
        }
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int count = scanner.nextInt();
//
//        /** 解法一 */
//        String[] array = new String[count];
//        for (int i = 0; i < count; i++) {
//            array[i] = scanner.next(); // 使用 nextLine() 执行结果会少接收一个字符串，可自行替换测试。
//        }
//        Arrays.sort(array);
//        for (String str : array) {
//            System.out.println(str);
//        }
//
//        /** 解法二 */
//        TreeSet treeSet = new TreeSet();
//        for (int i = 0; i < count; i++) {
//            treeSet.add(scanner.next()); // 使用 nextLine() 执行结果会少接收一个字符串，可自行替换测试。
//        }
//        Iterator iterator = treeSet.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//    }

}
