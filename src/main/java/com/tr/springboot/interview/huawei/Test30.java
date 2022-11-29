package com.tr.springboot.interview.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 字符串合并处理（复杂）
 * 原题链接：https://www.nowcoder.com/exam/oj/ta?tpId=37 --> HJ30
 *
 * 第一步：将输入的两个字符串str1和str2进行前后合并。如给定字符串 "dec" 和字符串 "fab" ， 合并后生成的字符串为 "decfab"
 *
 * 第二步：对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。
 *  这里的下标的意思是字符在字符串中的位置。注意排序后在新串中仍需要保持原来的奇偶性。
 *  例如刚刚得到的字符串“decfab”，分别对下标为偶数的字符'd'、'c'、'a'和下标为奇数的字符'e'、'f'、'b'，
 *  进行排序（生成 'a'、'c'、'd' 和 'b' 、'e' 、'f'），再依次分别放回原串中的偶数位和奇数位，新字符串变为 “abcedf”
 *
 * 第三步：对排序后的字符串中的'0'~'9'、'A'~'F'和'a'~'f'字符，需要进行转换操作。
 * 转换规则如下：
 *  对以上需要进行转换的字符所代表的十六进制用二进制表示并倒序，然后再转换成对应的十六进制大写字符（注：字符 a~f 的十六进制对应十进制的 10~15，大写同理）。
 *  如字符 '4'，其二进制为 0100 ，则翻转后为 0010 ，也就是 2。转换后的字符为 '2'。
 *  如字符 ‘7’，其二进制为 0111 ，则翻转后为 1110 ，对应的十进制是 14。转换为十六进制的大写字母为 'E'。
 *  如字符 'C'，代表的十进制是 12 ，其二进制为 1100 ，则翻转后为 0011，也就是 3。转换后的字符是 '3'。
 *  根据这个转换规则，由第二步生成的字符串 “abcedf” 转换后会生成字符串 "5D37BF"。
 *
 * 输入：dec fab
 * 输出：5D37BF
 *
 * 输入：ab CD
 * 输出：3B5D
 * 说明：合并后为 abCD，按奇数位和偶数位排序后是 CDab（请注意要按 ascii 码进行排序，所以 C 在 a 前面，D 在 b 前面），转换后为 3B5D
 *
 * 输入：123 15
 * 输出：88C4A
 *
 * @author TR
 * @date 2022/9/15 下午8:59
 */
public class Test30 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.next();
            String str2 = sc.next();
            System.out.println(mergeAndSortAndChange(str1, str2));
        }
    }

    /**
     * 对字符串进行：1.合并 2.排序 3.转换
     */
    public static String mergeAndSortAndChange(String str1, String str2) {
        // 1.合并
        String str = str1 + str2;
        // 2.排序
        ArrayList<Character> list1 = new ArrayList<>(); // 存放偶数位字符
        ArrayList<Character> list2 = new ArrayList<>(); // 存放奇数位字符
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                list1.add(str.charAt(i));
            } else {
                list2.add(str.charAt(i));
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        // 重新拼接
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list1.size(); i++) { // list1.size() >= list2.size()
            builder.append(list1.get(i));
            if (i <= list2.size() - 1) { // 防止越界
                builder.append(list2.get(i));
            }
        }
        // 3.对字符进行转换操作
        for (int i = 0; i < builder.length(); i++) {
            String s = builder.substring(i, i + 1);
            if (s.matches("[0-9a-fA-F]")) {
                // 把 16 进制转成 10 进制，再转成 2 进制
                StringBuilder binary = new StringBuilder(Integer.toBinaryString(Integer.parseInt(s, 16)));
                int len = binary.length();
                for (int j = 0; j < 4 - len; j++) { // 补零
                    binary.insert(0, "0"); // 永远补在第一个（即最左边）
                }
                binary = binary.reverse(); // 翻转
                int n = Integer.parseInt(binary.toString(), 2); // 把 2 进制转成 10 进制
                String hexString = Integer.toHexString(n).toUpperCase(); // 转成 16 进制字符串大写
                builder.replace(i, i + 1, hexString); // 替换
            }
        }
        return builder.toString();
    }

}
