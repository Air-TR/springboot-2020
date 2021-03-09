package com.tr.springboot.java8new;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Java8时间处理 - 测试类，代码来源：https://www.cnblogs.com/haixiang/p/12993399.html
 *
 * @Author: rtao
 * @Date: 2020/10/30 15:32
 **/
public class Java8DateTester {
    /**
     * Instant：瞬时实例
     * LocalDate：本地日期 不包含具体时间 例如 2020-02-02 可以用来记录纪念日
     * LocalTime：本地时间 不包含日期
     * LocalDateTime：结合了日期和时间 但不包含时差和时区
     * ZonedDateTime：完整的日期时间，包含时区和相对UTC或格林威治的视察
     *
     * ZoneOffSet,ZoneId：操作时区
     * DateTimeFormatter:格式化时间
     * LocalDate等许多类为 final 线程安全不可变， plusHour withDay等操作后要用新的对象来接收
     */
    public static void main(String[] args) {
        /** Date和LocalDate的转换: https://blog.csdn.net/hspingcc/article/details/73332252 */
        Date date = new Date();
        System.out.println(date); // Fri Oct 30 15:47:46 CST 2020

        LocalDate today = LocalDate.now();
        System.out.println(today); // 2020-10-30
        LocalTime time = LocalTime.now();
        System.out.println(time); // 15:37:20.859

        /* 处理特定日期  */
        LocalDate birthday = LocalDate.of(1995,7,4);
        System.out.println(birthday); // 1995-07-04

        /* 日期比较  */
        if (today.equals(birthday)) {
            System.out.println("日期比较相同");
        } else System.out.println("日期比较不同");

        /* MonthDay 和 YearMonth 用来检查某一天是不是生日这种周期性时间 */
        MonthDay myBithday = MonthDay.of(birthday.getMonth(), birthday.getDayOfMonth()); // 等同于 MonthDay.from(birthday);
        MonthDay currentMonDay = MonthDay.from(today);
        if (myBithday.equals(currentMonDay)) {
            System.out.println("今天是你的生日");
        } else System.out.println("今天不是你的生日");

        /* 在现有时间基础上计算之前之后的年、月、周、时、分、秒 */
        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println(nowTime); // 2020-10-30T15:58:02.369
        LocalDateTime afterTime = nowTime.plusHours(3);
        LocalDateTime beforeTime = nowTime.minusYears(2);
        System.out.println("afterTime: " + afterTime + " | beforeTime: " + beforeTime); // afterTime:2020-10-30T18:58:02.369 | beforeTime:2018-10-30T15:58:02.369

        /* 在现有时间基础上修改年、月、周、时、分、秒 */
        LocalDateTime localDateTime = nowTime.withHour(11);
        System.out.println("with 11 Time: " + localDateTime); // with 11 Time: 2020-10-30T11:58:02.369

        /* 使用java8的Clock时钟类获取时间戳 */
        Clock clock = Clock.systemUTC();
        System.out.println(clock.millis()); // 1590811768013
        System.out.println(System.currentTimeMillis()); // 1590811768013

        Clock defalutClock = Clock.systemDefaultZone();
        System.out.println(defalutClock.millis()); // 1590811768013
        System.out.println(defalutClock.getZone()); // Asia/Shanghai

        /* 判断早于某时还是晚于某时 */
        LocalDateTime tomorrow = nowTime.plusDays(1);
        if (tomorrow.isEqual(nowTime)) {
            System.out.println("时间相等");
        } else if (tomorrow.isAfter(nowTime)) {
            System.out.println("时间更大");
        } else if (tomorrow.isBefore(nowTime)) {
            System.out.println("时间更小");
        }

        /* 时区处理 */
        ZoneId newYork = ZoneId.of("America/New_York");
        LocalDateTime dateTimeNow = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTimeNow, newYork);
        System.out.println("纽约时间: " + zonedDateTime); // 纽约时间: 2020-10-30T16:26:39.313-04:00[America/New_York]

        /* 检测闰年 */
        LocalDate localDate = LocalDate.now();
        if (localDate.isLeapYear()){
            System.out.println(localDate.getYear() + "是闰年");
        }

        /* 计算两个时间之间的天数和月数 */
        LocalDate current = LocalDate.now();
        LocalDate yourBirthday = LocalDate.of(1995, 7, 4);
        Period between = Period.between(yourBirthday, current);
        System.out.println("你的生日距今: " + between.getYears() + "年" + between.getMonths() + "月" + between.getDays() + "天"); // 25年3月26天

        /* 包含时差信息的日期和时间
         *  ZoneOffset 表示时差 印度与GMT或者UTC飙车事件时差+5:30
         * */
        LocalDateTime dateTime = LocalDateTime.now(); // 2020-10-30T16:43:45.455
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime offsetDateTime = OffsetDateTime.of(dateTime, offset);
        System.out.println(offsetDateTime); // 2020-10-30T16:43:45.455+05:30
        System.out.println(OffsetDateTime.now()); // 2020-10-30T16:43:45.455+08:00

        /* 格式化时间 */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(LocalDateTime.now())); // 2020-10-30 16:43:45

    }

}
