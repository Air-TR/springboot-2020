package com.tr.springboot.thread.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池测试样例
 */
public class ThreadPoolDemo {

    private static ExecutorService executor = Executors.newFixedThreadPool(3);
    private static TaskDemo task;

    public static void main(String[] args) {
        ThreadPoolDemo threadPool = new ThreadPoolDemo();
        int threadNum = 0;
        while (threadNum < 9) {
            threadNum++;
            threadPool.start(threadNum);
        }
        /**
         * shutdown() 只是将线程池的状态设置为 SHUTDOWN 状态，正在执行的任务会继续执行下去，没有被执行的则中断。
         * shutdownNow() 则是将线程池的状态设置为 STOP，正在执行的任务则被停止，没被执行任务的则返回。
         */
        executor.shutdown();    // 等正在执行的任务执行完再关闭
//        executor.shutdownNow(); // 直接关闭
    }

    private void start(final int threadNum) {
        task = new TaskDemo(threadNum); // 创建任务
        executor.execute(task);     // 线程池执行任务
    }

}
