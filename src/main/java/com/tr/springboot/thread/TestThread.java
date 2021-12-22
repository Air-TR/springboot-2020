package com.tr.springboot.thread;

import com.tr.springboot.thread.service.ThreadService;
import com.tr.springboot.thread.service.impl.ThreadServiceImpl;

import java.time.LocalTime;

/**
 * 测试 Thread 效果
 *
 * @author TR
 * @version 1.0
 * @date 8/25/2020 10:58 AM
 */
public class TestThread {

    private static ThreadService threadService = new ThreadServiceImpl();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start ===> " + LocalTime.now());

        // 不用线程，下列方法依次执行 1+3+2 = 6 秒
//        threadService.methodA();
//        threadService.methodB();
//        threadService.methodC();

        // 使用线程，下列方法并行执行，只需 3 秒
        new Thread(() -> threadService.methodA()).start();
        new Thread(() -> threadService.methodB()).start();
        new Thread(() -> threadService.methodC()).start();

        System.out.println("End ===> " + LocalTime.now());
    }

}
