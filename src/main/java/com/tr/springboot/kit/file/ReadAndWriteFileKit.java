package com.tr.springboot.kit.file;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

/**
 * @Author: TR
 * @Date: 2023/8/28
 */
@Slf4j
public class ReadAndWriteFileKit {

    /**
     * 读取文件内容
     * @param filePath
     * @return
     * @throws IOException
     */
    public static final String readFromFile(String filePath) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        while (Objects.nonNull(str = in.readLine())) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    /**
     * 写入内容到文件
     * @param filePath
     * @param content
     * @throws IOException
     */
    public static final void writeToFile(String filePath, String content) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
        out.write(content);
        out.close();
    }

    /**
     * 判断文件夹是否存在，不存在创建对应文件夹
     * @param folderPath
     * @return
     */
    public static Boolean checkAndMkdirs(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                log.info("文件夹已创建成功");
            } else {
                log.error("无法创建文件夹");
                return false;
            }
        } else {
            log.info("文件夹已存在");
        }
        return true;
    }

}
