package com.tr.springboot.web.controller.threadpool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author TR
 * @date 2022/9/1 下午3:17
 */
@RestController
public class ThreadPoolTaskExecutorController {

    @Resource
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @GetMapping("/ThreadPoolTaskExecutor")
    public String threadPoolTaskExecutor() throws InterruptedException {
        System.out.println("/ThreadPoolTaskExecutor ==> " + LocalTime.now());

        int taskNum = 5; // 要执行的线程任务数
        CountDownLatch countDownLatch = new CountDownLatch(taskNum); // 要实现同步配置这个，异步不需要
        for (int i = 0; i < taskNum; i++) {
            int count = i + 1;
            threadPoolTaskExecutor.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(count + " -> CurrentThread Name: " + Thread.currentThread().getName() + " ==> " + LocalTime.now());
                countDownLatch.countDown(); // 要实现同步配置这个，异步不需要
            });
        }

        /**
         * 阻塞当前线程，直到所有子线程都执行 countDown() 方法才会继续执行。
         * 注释掉下面代码，该方法直接执行后续代码及返回结果，不再等待子线程执行完毕。
         *
         * timeout 参数：
         *  主线程最多阻塞等待 timeout 秒，超时不再等待子线程执行完毕，继续执行后续代码及返回结果。
         *  若没用到 timeout 秒，子线程已经全部执行完毕，主线程也不再等待，继续执行后续代码及返回结果。
         */
        countDownLatch.await(10, TimeUnit.SECONDS); // 要实现同步配置这个，异步不需要

        System.out.println("End ==> " + LocalTime.now());
        return "End ==> " + LocalTime.now();
    }

}
