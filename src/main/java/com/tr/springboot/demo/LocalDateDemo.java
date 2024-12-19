package com.tr.springboot.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @Author taorun
 * @Date 2024/12/18
 */
public class LocalDateDemo {

    public static void main(String[] args) {
        of();
    }

    private static void of() {
        LocalDate now = LocalDate.now();
        LocalDateTime startDate = LocalDateTime.of(now, LocalTime.of(0, 0, 5));
        System.out.println(now);
        System.out.println(startDate);
    }

    private static void until() {
        // 假设有两个日期
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate execDate = LocalDate.of(2023, 1, 5);

        // 计算两个日期之间的天数差
        long daysBetween = startDate.until(execDate, ChronoUnit.DAYS);

        // 检查天数差是否大于1
        if (daysBetween > 1) {
            System.out.println("两个日期之间的天数差大于1天。");
        } else {
            System.out.println("两个日期之间的天数差不大于1天。");
        }
    }

}
