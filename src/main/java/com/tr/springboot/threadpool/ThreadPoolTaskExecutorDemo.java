package com.tr.springboot.threadpool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.time.LocalTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolTaskExecutor 使用示例
 *
 * @Author TR
 * @date 2022/9/1 下午6:16
 */
public class ThreadPoolTaskExecutorDemo {

    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int QUEUE_CAPACITY = 10;
    private static final int KEEP_ALIVE_SECONDS = 1;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start ==> " + LocalTime.now());

        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        taskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        taskExecutor.setQueueCapacity(QUEUE_CAPACITY);
        taskExecutor.setKeepAliveSeconds(KEEP_ALIVE_SECONDS);
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();

        int taskNum = 5; // 要执行的线程任务数
        CountDownLatch countDownLatch = new CountDownLatch(taskNum); // 要实现同步配置这个，异步不需要

        for (int i = 0; i < taskNum; i++) {
            int count = i + 1;
            taskExecutor.execute(() -> {
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

        /**
         * 终止线程池
         *  shutdown() 只是将线程池的状态设置为 SHUTDOWN 状态，正在执行的任务会继续执行下去，没有被执行的则中断。
         *  shutdownNow() 则是将线程池的状态设置为 STOP，正在执行的任务则被停止，没被执行任务的则返回。
         *
         * 注：自己 new 的新线程要手动 shutdown()，Spring 管理的线程池不需要手动 shutdown()
         */
        taskExecutor.shutdown();

        System.out.println("End ==> " + LocalTime.now());
    }

}
