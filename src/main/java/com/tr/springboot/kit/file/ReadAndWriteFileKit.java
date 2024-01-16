package com.tr.springboot.kit.file;

import com.alibaba.fastjson.JSONObject;
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

    public static void main(String[] args) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url", "https://blog.51cto.com/u_12959/6557665");
        writeToFile("D:/hbmes/scada-exe/app.json", jsonObject.toJSONString());
    }

    /**
     * 读取文件内容
     */
    public static final String readFromFile(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {
            String str;
            while (Objects.nonNull(str = in.readLine())) {
                stringBuilder.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * 写入内容到文件
     */
    public static final void writeToFile(String filePath, String content) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filePath))) {
            out.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
