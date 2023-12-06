package com.tr.springboot.interview.huawei;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 密码验证合格程序
 * 密码要求:
 *  1.长度超过 8 位
 *  2.包括大小写字母、数字、其它符号，以上四种至少三种
 *  3.不能有长度大于 2 的包含公共元素的子串重复（注：其他符号不含空格或换行）
 *
 * @Author TR
 * @date 2022/9/15 上午11:28
 */
public class Test20 {

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (str.contains(" ")) {
                System.out.println("NG");
                continue;
            }
            if (str.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            if (regexMatch(str)) {
                System.out.println("NG");
                continue;
            }
            if (checkRepeat(str, 0, 3)) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }

    // 校验是否有重复子串
    private static boolean checkRepeat(String str, int l, int r) {
        if (r >= str.length()) {
            return false;
        }
        if (str.substring(r).contains(str.substring(l, r))) {
            return true;
        } else {
            return checkRepeat(str, l + 1, r + 1);
        }
    }

    // 检查是否满足正则
    private static boolean regexMatch(String str) {
        int count = 0;
        Pattern p1 = Pattern.compile("[A-Z]");
        if (p1.matcher(str).find()) {
            count++;
        }
        Pattern p2 = Pattern.compile("[a-z]");
        if (p2.matcher(str).find()) {
            count++;
        }
        Pattern p3 = Pattern.compile("[0-9]");
        if (p3.matcher(str).find()) {
            count++;
        }
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
        if (p4.matcher(str).find()) {
            count++;
        }
        if (count >= 3) {
            return false;
        } else {
            return true;
        }
    }

}
