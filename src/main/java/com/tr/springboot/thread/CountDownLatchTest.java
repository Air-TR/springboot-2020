package com.tr.springboot.thread;

import com.tr.springboot.thread.service.ThreadService;
import com.tr.springboot.thread.service.impl.ThreadServiceImpl;

import java.time.LocalTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch 测试
 * 主线程等待其他（多个）线程执行完成再继续执行
 *
 * @author TR
 * @version 1.0
 * @date 9/10/2020 1:07 PM
 */
public class CountDownLatchTest {

    private static ThreadService threadService = new ThreadServiceImpl();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread start ===> " + LocalTime.now());

        /**
         * new CountDownLatch(int count)
         *  count 参数写几，就要 latch.countDown() 几次，不足会一直处于 latch.await() 等待不结束
         *  若 latch.countDown() 次数大于 count 参数值，则前 count 个线程执行结束，就结束 latch.await() 等待
         */
        final CountDownLatch latch = new CountDownLatch(3);

        new Thread(() -> {
            threadService.methodA();
            latch.countDown();
        }).start();

        new Thread(() -> {
            threadService.methodB();
            latch.countDown();
        }).start();

        new Thread(() -> {
            threadService.methodC();
            latch.countDown();
        }).start();

        latch.await();

        System.out.println("main thread over  ===> " + LocalTime.now());
    }

}
