package com.tr.springboot.interview.huawei;

import java.util.Scanner;

/**
 * 复杂 —— 识别有效的IP地址和掩码并进行分类统计
 * 原题链接：https://www.nowcoder.com/exam/oj/ta?tpId=37 --> HJ18
 *
 * 输入：
 *  10.70.44.68~255.254.255.0
 *  1.0.0.1~255.0.0.0
 *  192.168.0.2~255.255.255.0
 *  19..0.~255.255.255.0
 * 输出：
 *  1 0 1 0 0 2 1
 * 说明：
 *  10.70.44.68~255.254.255.0 的子网掩码非法，19..0.~255.255.255.0的IP地址非法，所以错误IP地址或错误掩码的计数为2；
 *  1.0.0.1~255.0.0.0是无误的A类地址；
 *  192.168.0.2~255.255.255.0是无误的C类地址且是私有IP；
 *  所以最终的结果为1 0 1 0 0 2 1
 *
 *
 * 输入：
 *  0.201.56.50~255.255.111.255
 *  127.201.56.50~255.255.111.255
 * 输出：
 *  0 0 0 0 0 0 0
 * 说明：
 *  类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略
 *
 * @Author TR
 * @date 2022/9/15 上午10:27
 */
public class Test18 {

    /**
     * 测试时 ctrl+d 结束输入
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aNum = 0;
        int bNum = 0;
        int cNum = 0;
        int dNum = 0;
        int eNum = 0;
        int errNum = 0;
        int pNum = 0;
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] strArr = str.split("~");
            int ipFirst = getIpSeg(strArr[0], 0);
            if (ipFirst == 0 || ipFirst == 127) {
                continue;
            }
            if (maskIsInvaild(strArr[1])) {
                errNum++;
                continue;
            }
            if (ipIsInvaild(strArr[0])) {
                errNum++;
                continue;
            }
            if (ipFirst >= 1 && ipFirst <= 126) {
                aNum++;
            }
            if (ipFirst >= 128 && ipFirst <= 191) {
                bNum++;
            }
            if (ipFirst >= 192 && ipFirst <= 223) {
                cNum++;
            }
            if (ipFirst >= 224 && ipFirst <= 239) {
                dNum++;
            }
            if (ipFirst >= 240 && ipFirst <= 255) {
                eNum++;
            }
            int ipSecond = getIpSeg(strArr[0], 1);
            if (ipFirst == 10 || (ipFirst == 172 && ipSecond >= 16 && ipSecond <=31) || (ipFirst == 192 && ipSecond == 168)) {
                pNum++;
            }
        }
        System.out.println(aNum + " " + bNum + " " + cNum + " " + dNum + " " + eNum + " " + errNum + " " + pNum);
    }

    public static boolean maskIsInvaild(String mask) {
        String[] maskArr = mask.split("\\.");
        if (maskArr.length != 4) {
            return true;
        }
        String maskBinary = toBinary(maskArr[0]) + toBinary(maskArr[1]) + toBinary(maskArr[2]) + toBinary(maskArr[3]);
        if (!maskBinary.matches("[1]{1,}[0]{1,}")) {
            return true;
        }
        return false;
    }

    public static String toBinary(String num) {
        String numBinary = Integer.toBinaryString(Integer.valueOf(num));
        while (numBinary.length() < 8) {
            numBinary = "0" + numBinary;
        }
        return numBinary;
    }

    public static boolean ipIsInvaild(String ip) {
        String[] ipArr = ip.split("\\.");
        if (ipArr.length != 4) {
            return true;
        }
        if (Integer.valueOf(ipArr[0]) > 255 || Integer.valueOf(ipArr[1]) > 255 || Integer.valueOf(ipArr[2]) > 255 || Integer.valueOf(ipArr[3]) > 255) {
            return true;
        }
        return false;
    }

    public static int getIpSeg(String ip, int index) {
        String[] ipArr = ip.split("\\.");
        return Integer.valueOf(ipArr[index]);
    }

}
