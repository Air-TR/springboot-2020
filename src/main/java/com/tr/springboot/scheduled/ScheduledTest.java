//package com.tr.springboot.scheduled;
//
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
///**
// * 定时任务类
// * 注：在启动类application上加入@EnableScheduling注解
// *
// * @author TR
// * @version 1.0
// * @date 8/19/2020 2:24 PM
// */
//@Component // 不加 @Component 不自动执行，扫描不到
//public class ScheduledTest {
//
//    /**
//     * cron 网站：http://cron.qqe2.com/
//     */
//    @Scheduled(cron = "0 0/1 * * * ?")
//    private void test() {
//        System.out.println("执行定时任务的时间是：" + new Date());
//    }
//
//}
