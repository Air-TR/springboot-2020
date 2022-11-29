package com.tr.springboot.interview.huawei;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *
 * 输入：aabcddd
 * 输出：aaddd
 *
 * @author TR
 * @date 2022/9/15 下午4:14
 */
public class Test23 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            // 统计每个字母的数量
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : chars) {
                map.put(c, (map.getOrDefault(c, 0) + 1));
            }
            // 找到数量最少的字符数量
            Collection<Integer> values = map.values();
            Integer min = Collections.min(values);

            // 用空字符串替换该字母
            for (Character character : map.keySet()) {
                if (map.get(character) == min){
                    str = str.replaceAll(String.valueOf(character), "");
                }
            }
            System.out.println(str);
        }
    }

}
