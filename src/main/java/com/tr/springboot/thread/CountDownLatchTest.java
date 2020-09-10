package com.tr.springboot.thread;

import com.tr.springboot.thread.service.ThreadService;
import com.tr.springboot.thread.service.impl.ThreadServiceImpl;
import com.tr.springboot.web.entity.Entity;

import java.util.concurrent.CountDownLatch;

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
        long start = System.currentTimeMillis();

        final CountDownLatch latch = new CountDownLatch(3);

        Entity entity = new Entity();

        new Thread(() -> {
            entity.setV1(threadService.methodA());
            latch.countDown();
        }).start();

        new Thread(() -> {
            entity.setV2(threadService.methodB());
            latch.countDown();
        }).start();

        new Thread(() -> {
            entity.setV3(threadService.methodC());
            latch.countDown();
        }).start();

        latch.await();
        System.out.println(entity.toString());

        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");
    }

}
