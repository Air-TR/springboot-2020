package com.tr.springboot;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @Author: TR
 * @Date: 2023/7/20
 */
public class ReadAndWriteJson {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // 读取 JSON 文件并转换为 JSON 对象
            File file = new File("electron-hb/package.json");
            HashMap jsonMap = (HashMap) objectMapper.readValue(file, Object.class);

            HashMap buildMap = (HashMap) jsonMap.get("build");
            buildMap.put("productName", "abc");

            objectMapper.writeValue(file, jsonMap);
            // 打印 JSON 对象
            System.out.println(jsonMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
