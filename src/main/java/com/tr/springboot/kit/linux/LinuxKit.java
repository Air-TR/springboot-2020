package com.tr.springboot.kit.linux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: TR
 * @Date: 2023/11/1
 */
public class LinuxKit {

    /**
     * 获取 CPU 序列号
     */
    public static String getCPUSerial() {
        String result = "";
        String CPU_ID_CMD = "dmidecode";
        BufferedReader bufferedReader = null;
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(new String[] { "sh", "-c", CPU_ID_CMD }); // 管道
            bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            int index = -1;
            while ((line = bufferedReader.readLine()) != null) {
                index = line.toLowerCase().indexOf("uuid");
                if (index >= 0) {
                    result = line.substring(index + "uuid".length() + 1).trim();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("获取 CPU 序列号异常：" + e.getMessage());
        }
        return result.trim();
    }

    /**
     * 获取系统序列号
     */
    public static String getSystemSerial() {
        return getSerial("dmidecode -t system | grep 'Serial Number' | awk '{print $3}' | tail -1");
    }

    /**
     * 获取主板序列号
     */
    public static String getBaseboardSerial() {
        return getSerial("dmidecode -t baseboard | grep 'Serial Number' | awk '{print $3}' | tail -1");
    }

    /**
     * 获取硬盘序列号
     */
    public static String getDiskSerial() {
        return getSerial("fdisk -l |grep 'Disk identifier' | awk {'print $3'} | tail -1");
    }

    public static String getSerial(String command) {
        String result = "";
        Process p;
        try {
            p = Runtime.getRuntime().exec(new String[] { "sh", "-c", command }); // 管道
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                result += line;
                break;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("获取主板序列号异常：" + e.getMessage());
        }
        return result;
    }

}
