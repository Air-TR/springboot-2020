package com.tr.springboot.kit.windows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: TR
 * @Date: 2023/9/20
 */
public class WindowsKit {

    /**
     * 获取 CPU 序列号
     */
    public static String getCPUSerialNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        String command = "wmic cpu get processorid";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(command).getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains("ProcessorId")) {
                    stringBuilder.append(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString().trim();
    }

    /**
     * 获取主板序列号
     */
    public static String getMainBoardSerialNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        String command = "wmic baseboard get serialnumber";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(command).getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains("SerialNumber")) {
                    stringBuilder.append(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString().trim();
    }

    /**
     * 获取硬盘序列号
     */
    public static String getHardDiskSerialNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        String command = "wmic path win32_physicalmedia get serialnumber";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(command).getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains("SerialNumber"))
                    stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString().trim();
    }

}
