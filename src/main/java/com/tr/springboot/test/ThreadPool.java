package com.tr.springboot.test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池测试样例
 */
public class ThreadPool {
    private static ExecutorService executor = Executors.newFixedThreadPool(3);
    private static Task task;

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
        int ThreadNum = 0;
        while (ThreadNum < 6) {
            ThreadNum++;
            threadPool.start(ThreadNum);
        }
    }

    private void start(final int ThreadNum) {
        task = new Task(ThreadNum);
        executor.execute(task);
    }
}

class Task extends Thread {
    private int ThreadNum;

    Task(int temp) {
        ThreadNum = temp;
    }

    public void run() {
        System.out.println(super.getName());
        System.out.println("当前执行了：" + ThreadNum);
        try {
            Random random = new Random();
            int sleep = random.nextInt(1) + 3;
            System.out.println(ThreadNum + ">>停止" + sleep + "秒");
            Thread.sleep(sleep * 1000);
        } catch (InterruptedException e) {
            System.out.println("执行过程中出现线程暂停异常" + e);
        }
        System.out.println(ThreadNum + ">>执行完成");
        System.gc();
    }
}
