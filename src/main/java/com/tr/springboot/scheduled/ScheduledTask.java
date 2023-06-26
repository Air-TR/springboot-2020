package com.tr.springboot.scheduled;

import com.tr.springboot.kit.DateKit;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: TR
 * @Date: 2023/6/19
 */
public class ScheduledTask {

    public static void main(String[] args) {
        String content = "定时内容打印";
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println(content);
                cancel(); // 取消定时器
            }
        };
        Timer timer = new Timer();
        Date runTime = DateKit.parse("2023-06-19 09:55:10");
        timer.schedule(task, runTime);
    }

}
