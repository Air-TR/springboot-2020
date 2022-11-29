//package com.tr.springboot.scheduled;
//
//import org.quartz.CronExpression;
//import org.quartz.CronTrigger;
//import org.quartz.Job;
//import org.quartz.JobDetail;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.quartz.Scheduler;
//import org.quartz.SchedulerException;
//import org.quartz.SchedulerFactory;
//import org.quartz.impl.StdSchedulerFactory;
//
//import java.text.ParseException;
//
///**
// * 自动定时任务触发（cron 表达式在代码中指定）
// *
// * @author rtao
// * @date 2021/8/16 18:21
// */
//public class ScheduleInCodeTest implements Job {
//
//    @Override
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//        String param = context.getJobDetail().getJobDataMap().getString("param");
//        System.out.println("==================> " + param);
//    }
//
//    public static void main(String[] args) {
//        JobDetail detail = new JobDetail("job1", "group1", ScheduleInCodeTest.class);
//        detail.getJobDataMap().put("param", "ok");
//        CronTrigger cronTrigger = new CronTrigger("job1", "group1");
//        CronExpression cronExpression = null;
//        try {
//            cronExpression = new CronExpression("0/1 * * * * ?");
//            cronTrigger.setCronExpression(cronExpression);
//            SchedulerFactory factory = new StdSchedulerFactory();
//            Scheduler scheduler = factory.getScheduler();
//            scheduler.scheduleJob(detail, cronTrigger);
//            scheduler.start();
//        } catch (ParseException | SchedulerException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
