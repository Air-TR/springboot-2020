package com.tr.springboot.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author TR
 * @date 2022/9/15 上午10:58
 */
public class WriteToFile {

    public static void main(String[] args) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("/license/web-config/test.txt"));
            out.write("写入内容：ABC");
            out.close();
            System.out.println("文件写入成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
