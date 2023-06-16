package com.tr.springboot.kit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * 读取 json 文件
 *
 * @author rtao
 * @date 2021/5/12 16:35
 */
public class ReadJsonFileUtil {

    /**
     * 读取 json 文件，返回 json 串
     */
    public static String readJsonFile(String filePath) {
        String jsonStr = "";
        try {
            File jsonFile = new File(filePath);
            if (jsonFile.isFile() && jsonFile.exists()) {
                FileReader fileReader = new FileReader(jsonFile);
                Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"UTF-8");
                int ch = 0;
                StringBuffer sb = new StringBuffer();
                while ((ch = reader.read()) != -1) {
                    sb.append((char) ch);
                }
                fileReader.close();
                reader.close();
                jsonStr = sb.toString();
                return jsonStr;
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
