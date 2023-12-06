package com.tr.springboot.interview.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 坐标移动
 * 原题链接：https://www.nowcoder.com/exam/oj/ta?tpId=37 --> HJ17
 *
 * 输入：A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 输出：10,-10
 *
 * 输入：ABC;AKL;DA1;
 * 输出：0,0
 *
 * @Author TR
 * @date 2022/9/15 上午10:23
 */
public class Test17 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] in = bf.readLine().split(";");
        int x = 0;
        int y = 0;
        for (String s : in) {
            // 不满足题目给定坐标规则
            if (!s.matches("[WASD][0-9]{1,2}")) {
                continue;
            }
            int val = Integer.valueOf(s.substring(1));
            switch (s.charAt(0)) {
                case 'W':
                    y += val;
                    break;
                case 'S':
                    y -= val;
                    break;
                case 'A':
                    x -= val;
                    break;
                case 'D':
                    x += val;
                    break;
            }
        }
        System.out.println(x + "," + y);
    }

}
