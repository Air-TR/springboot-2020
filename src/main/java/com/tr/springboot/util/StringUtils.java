package com.tr.springboot.util;

import java.util.Objects;

/**
 * String 工具类
 *
 * @author TR
 * @date 2021/11/11 上午11:26
 */
public class StringUtils {

//    public static void main(String[] args) {
//        String str = " ";
//        System.out.println(str.trim());
//        System.out.println(isNotEmpty(str));
//        System.out.println(isNotBlank(str));
//    }

    public static boolean isEmpty(String string) {
        return Objects.isNull(string) || string.isEmpty();
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static boolean isBlank(String string) {
        return Objects.isNull(string) || string.trim().isEmpty();
    }

    public static boolean isNotBlank(String string) {
        return !isBlank(string);
    }

}
