package com.tr.springboot.interview.huawei;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * 开发一个错误记录功能，能够记录出错的代码所在的文件名称和行号。
 * 原题链接：https://www.nowcoder.com/exam/oj/ta?tpId=37 --> HJ19
 *
 * @Author TR
 * @date 2022/9/15 上午11:17
 */
public class Test19 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        while (sc.hasNext()) {
            String str = sc.next();
            int LineNum = sc.nextInt();
            String[] split = str.split("\\\\");  // 根据\分割
            String FileName = split[split.length - 1];
            // 只保留最后 16 位
            if (FileName.length() > 16) {
                FileName = FileName.substring(FileName.length() - 16);
            }
            String key = FileName + " " + LineNum;
            // 放入到 HashMap 中
            int Number = 1;
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, Number);
            }
        }
        int count = 0;
        for (String string : map.keySet()) {
            count++;
            if (count > (map.keySet().size() - 8)) { // 输出最后 8 个记录
                System.out.println(string + " " + map.get(string));
            }
        }
    }

}
