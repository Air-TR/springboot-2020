package com.tr.springboot.kit;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

}
