package com.tr.springboot.kit;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author taorun
 * @date 2022/12/15
 */
public class DateKit extends DateUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "HH:mm:ss";
    public static final String HOUR_MINUTE_FORMAT = "HH:mm";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_MS_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String YEAR_FORMAT = "yyyy";
    public static final String YEAR_MONTH_FORMAT = "yyyy-MM";
    public static final String S_DATE_FORMAT = "yyyy/MM/dd";
    public static final String S_DATE_TIME_FORMAT_X = "yyyy/MM/dd HH:mm:ss";
    public static final String S_DATE_TIME_MS_FORMAT_X = "yyyy/MM/dd HH:mm:ss.SSS";
    public static final String N_DATE_FORMAT = "yyyyMMdd";
    public static final String N_DATE_TIME_FORMAT_X = "yyyyMMdd HH:mm:ss";
    public static final String N_DATE_TIME_MS_FORMAT_X = "yyyyMMdd HH:mm:ss.SSS";

    private static String[] parsePatterns = {
            DATE_FORMAT, DATE_TIME_FORMAT, DATE_TIME_MS_FORMAT, YEAR_FORMAT, YEAR_MONTH_FORMAT,
            S_DATE_FORMAT, S_DATE_TIME_FORMAT_X, S_DATE_TIME_MS_FORMAT_X,
            N_DATE_FORMAT, N_DATE_TIME_FORMAT_X, N_DATE_TIME_MS_FORMAT_X};

    public static Date parse(String dateStr) {
        if (StringKit.isBlank(dateStr)) return null;
        try {
            return parseDate(dateStr, parsePatterns);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String format(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static String getDateTime() {
        return format(new Date(), DateKit.DATE_TIME_FORMAT);
    }

    public static String getDate() {
        return format(new Date(), DateKit.DATE_FORMAT);
    }

    public static String getTime() {
        return format(new Date(), DateKit.TIME_FORMAT);
    }

    /**
     * 根据日期获取星期几
     * @param dateStr：只接收 yyyy-MM-dd 格式
     * @return MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
     */
    public static DayOfWeek getWeekDay(String dateStr) { // 只接收类型 yyyy-MM-dd
        LocalDate date = LocalDate.parse(dateStr);
        return date.getDayOfWeek();
    }

    /**
     * 根据日期获取星期几
     * @param dateStr：只接收 yyyy-MM-dd 格式
     * @return 1,2,3,4,5,6,7（就是从 1 开始，不是从 0 开始）
     */
    public static Integer getWeekInt(String dateStr) {
        LocalDate date = LocalDate.parse(dateStr);
        return date.getDayOfWeek().getValue();
    }

    /**
     * 获取今天星期几 —— DayOfWeek
     */
    public static DayOfWeek getTodayWeekDay() {
        return LocalDate.now().getDayOfWeek();
    }

    /**
     * 获取今天星期几 —— 1,2,3,4,5,6,7
     */
    public static Integer getTodayWeekInt() {
        return getTodayWeekDay().getValue();
    }

}
