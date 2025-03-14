package com.tr.springboot.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/**
 * @Author TR
 * @date 2022/9/15 上午11:01
 */
public class ReadFromFile {

    public static void main(String[] args)  {
        try {
            BufferedReader in = new BufferedReader(new FileReader("D:/license/web-config/license.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            String str;
            while (Objects.nonNull(str = in.readLine())) {
                System.out.println(str);
                stringBuilder.append(str);
            }
            System.out.println("总结果：");
            System.out.println(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
