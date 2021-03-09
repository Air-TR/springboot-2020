package com.tr.springboot.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author rtao
 * @date 2020/11/17 11:25
 */
public class ReadJsonFileUtil {

    /**
     * 读取json文件，返回json串
     * @author: rtao
     * @date: 2020/11/17 11:25
     **/
    public static String readJsonFile(String filePath, String charsetName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(filePath);
            if (jsonFile.isFile() && jsonFile.exists()) {
                FileReader fileReader = new FileReader(jsonFile);
                Reader reader = new InputStreamReader(new FileInputStream(jsonFile), charsetName);
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
