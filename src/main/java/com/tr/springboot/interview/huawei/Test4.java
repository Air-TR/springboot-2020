package com.tr.springboot.interview.huawei;

import java.util.Scanner;

/**
 * 输入一个字符串，请按长度为 8 拆分每个输入字符串并进行输出；
 * 长度不是 8 整数倍的字符串请在后面补数字 0，空字符串不处理。
 *
 * @author TR
 * @date 2022/9/14 下午5:55
 */
public class Test4 {

    /** 答案 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            while (str.length() >= 8) {
                System.out.println(str.substring(0, 8));
                str = str.substring(8);
            }
            if (str.length() < 8 && str.length() > 0) {
                str += "00000000";
                System.out.println(str.substring(0, 8));
            }
        }
    }

}
