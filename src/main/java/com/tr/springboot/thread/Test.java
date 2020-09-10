package com.tr.springboot.thread;

import com.tr.springboot.thread.service.ThreadService;
import com.tr.springboot.thread.service.impl.ThreadServiceImpl;
import com.tr.springboot.web.entity.Entity;

import java.util.concurrent.CountDownLatch;

/**
 * @author TR
 * @version 1.0
 * @date 8/25/2020 10:58 AM
 */
public class Test {

    private static ThreadService threadService = new ThreadServiceImpl();

    public static void main(String[] args) throws InterruptedException {
//        String a = threadService.methodA();
//        String b = threadService.methodB();
//        String c = threadService.methodC();
//        System.out.println(a + b + c + "\n");

        long start = System.currentTimeMillis();

        final CountDownLatch latch = new CountDownLatch(3);

        Entity entity = new Entity();

        Thread t1 = new Thread(() -> {
            entity.setV1(threadService.methodA());
            latch.countDown();
        });
        t1.start();
//        t1.join();

        Thread t2 = new Thread(() -> {
            entity.setV2(threadService.methodB());
            latch.countDown();
        });
        t2.start();
//        t2.join();

        Thread t3 = new Thread(() -> {
            entity.setV3(threadService.methodC());
            latch.countDown();
        });
        t3.start();
//        t3.join();

        latch.await();
//        Thread.sleep(5000);
        System.out.println(entity.toString());

        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");

//        new Thread(() -> threadService.methodA()).start();
//        new Thread(() -> threadService.methodB()).start();
//        new Thread(() -> threadService.methodC()).start();

    }

}
