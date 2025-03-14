package com.tr.springboot.reflection;

import java.lang.reflect.Field;

/**
 * @Author taorun
 * @Date 2025/3/13
 */
public class ReflectionSoutTest {

    private String log1 = "Log 1 content";
    private String log2 = "Log 2 content";
    private String log3 = "Log 3 content";
    private String log4 = "Log 4 content";
    private String log5 = "Log 5 content";
    private String log6 = "Log 6 content";
    private String log7 = "Log 7 content";
    private String log8 = "Log 8 content";
    private String log9 = "Log 9 content";
    private String log10 = "Log 10 content";
    private String log11 = "Log 11 content";
    private String log12 = "Log 12 content";
    private String log13 = "Log 13 content";
    private String log14 = "Log 14 content";
    private String log15 = "Log 15 content";
    private String log16 = "Log 16 content";
    private String log17 = "Log 17 content";
    private String log18 = "Log 18 content";
    private String log19 = "Log 19 content";
    private String log20 = "Log 20 content";

    public static void main(String[] args) {
        ReflectionSoutTest logInstance = new ReflectionSoutTest();
        try {
            for (int i = 1; i <= 20; i++) {
                Field field = ReflectionSoutTest.class.getDeclaredField("log" + i);
                field.setAccessible(true); // 允许访问私有字段
                String logContent = (String) field.get(logInstance);
                System.out.println("log" + i + ": " + logContent);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
