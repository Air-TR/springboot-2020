package com.tr.springboot;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: TR
 * @Date: 2023/7/13
 */
public class CmdCaller {
    public static void main(String[] args) {
//        try {
//            // 创建ProcessBuilder对象，并指定工作目录
//            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "cd /d D:/GitLab/bak && npm run build:win64");
//            // 启动进程
//            Process process = processBuilder.start();
//            // 读取命令输出
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//            // 关闭流
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            // 创建ProcessBuilder对象
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "npm run build:win64");

            // 设置工作目录（可选）
            processBuilder.directory(new File("D:/GitLab/bak"));

            // 启动进程
            Process process = processBuilder.start();

            // 读取命令输出
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // 关闭流
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}