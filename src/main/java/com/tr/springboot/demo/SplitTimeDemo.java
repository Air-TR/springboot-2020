package com.tr.springboot.demo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class SplitTimeDemo {

    public static void main(String[] args) {
        LocalDateTime startTime = LocalDateTime.of(2024, 12, 18, 8, 20, 00);
        LocalDateTime endTime = LocalDateTime.of(2024, 12, 18, 10, 20, 00);

        Map<LocalDateTime, Long> map = segmentTime(startTime, endTime);

        System.out.println();
    }

    /**
     * 将 startTime 到 endTime 按整小时划分到不同的时间区间，并返回在时间区间的秒数
     * @param startTime
     * @param endTime
     * @return
     */
    public static Map<LocalDateTime, Long> segmentTime(LocalDateTime startTime, LocalDateTime endTime) {
        Map<LocalDateTime, Long> map = new HashMap<>();

        // 处理 startTime 和 endTime 在不同日期的情况
        LocalDateTime currentDateTime = startTime.withMinute(0).withSecond(0).withNano(0);
        LocalDateTime nextDateTime = currentDateTime.plusHours(1);

        // 如果 endTime 早于同一天的下一个小时，将 nextDateTime 调整为 endTime 的日期
        if (endTime.toLocalDate().equals(startTime.toLocalDate()) && endTime.isBefore(nextDateTime)) {
            nextDateTime = endTime.withMinute(0).withSecond(0).withNano(0);
        }

        // 遍历每个小时段
        while (!currentDateTime.isAfter(endTime)) {
            LocalDateTime segmentStart = (currentDateTime.isBefore(startTime)) ? startTime : currentDateTime;
            LocalDateTime segmentEnd = (nextDateTime.isAfter(endTime)) ? endTime : nextDateTime;

            if (segmentStart.isBefore(segmentEnd)) {
                Duration duration = Duration.between(segmentStart, segmentEnd);
                map.put(currentDateTime, duration.toSeconds());
            }

            // 移动到下一个小时，必要时根据日期变化进行调整
            currentDateTime = nextDateTime;
            nextDateTime = currentDateTime.plusHours(1);

            // 如果已经过了凌晨（下一天），将 nextDateTime 调整为正确的日期
            if (nextDateTime.toLocalDate().isBefore(currentDateTime.toLocalDate())) {
                nextDateTime = nextDateTime.with(endTime.toLocalDate());
            }
        }

        return map;
    }

}