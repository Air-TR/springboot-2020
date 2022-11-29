package com.tr.springboot.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/**
 * @author TR
 * @date 2022/9/15 上午11:01
 */
public class ReadFromFile {

    public static void main(String[] args)  {
        try {
            BufferedReader in = new BufferedReader(new FileReader("/Users/taorun/File/test.txt"));
            String str;
            while (Objects.nonNull(str = in.readLine())) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
