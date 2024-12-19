package com.tr.springboot.thread;

import java.util.concurrent.Semaphore;

/**
 * @Author taorun
 * @Date 2024/12/18
 */
public class SemaphoreDemo {

    // 创建一个具有3个许可的Semaphore
    private static final Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Worker()).start();
        }
    }

    static class Worker implements Runnable {
        @Override
        public void run() {
            try {
                // 尝试获取一个许可
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " 获取了一个许可，进入临界区。");
                // 模拟处理任务
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // 释放许可
                System.out.println(Thread.currentThread().getName() + " 释放了一个许可，离开临界区。------------");
                semaphore.release();
            }
        }
    }

}
