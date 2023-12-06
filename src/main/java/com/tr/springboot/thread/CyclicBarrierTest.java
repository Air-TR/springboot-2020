package com.tr.springboot.thread;

import com.tr.springboot.thread.service.ThreadService;
import com.tr.springboot.thread.service.impl.ThreadServiceImpl;
import com.tr.springboot.web.entity.Entity;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 测试
 * CyclicBarrier 要比 CountDownLatch 多 1
 * 比如：开三个线程，CountDownLatch 配 3，CyclicBarrier 要配 4。
 *
 * @Author TR
 * @version 1.0
 * @date 9/10/2020 1:18 PM
 */
public class CyclicBarrierTest {

    private static ThreadService threadService = new ThreadServiceImpl();

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        long start = System.currentTimeMillis();

        final CyclicBarrier barrier = new CyclicBarrier(4);

        Entity entity = new Entity();

        new Thread(() -> {
            entity.setV1(threadService.methodA());
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            entity.setV2(threadService.methodB());
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            entity.setV3(threadService.methodC());
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        barrier.await();
        System.out.println(entity.toString());

        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms");
    }

}
