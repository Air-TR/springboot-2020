package com.tr.springboot.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author TR
 * @version 1.0
 * @date 8/25/2020 11:59 AM
 */
public class ThreadPool {

//    private static ExecutorService executor = Executors.newFixedThreadPool(3);

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            5,
            10,
            5l,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(100),
            new ThreadPoolExecutor.CallerRunsPolicy());

    private static Task task;

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
        int threadNum = 0;
        while (threadNum < 15) {
            int type = (int) (Math.random() * 3) + 1;
            threadNum++;
            threadPool.start(threadNum, type);
        }
        /**
         * shutdown() 只是将线程池的状态设置为 SHUTDOWN 状态，正在执行的任务会继续执行下去，没有被执行的则中断。
         * shutdownNow() 则是将线程池的状态设置为 STOP，正在执行的任务则被停止，没被执行任务的则返回。
         */
        executor.shutdown();    // 等正在执行的任务执行完再关闭
//        executor.shutdownNow(); // 直接关闭
    }

    private void start(final int threadNum, final int type) {
        task = new Task(threadNum, type); // 创建任务
        executor.execute(task);     // 线程池执行任务
    }

}
