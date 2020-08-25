package com.tr.springboot.thread;

import java.time.Instant;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author TR
 * @version 1.0
 * @date 8/25/2020 2:17 PM
 */
public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        /**
         * 阿里巴巴推荐的创建线程池的方式
         * 通过ThreadPoolExecutor构造函数自定义参数创建
         * public ThreadPoolExecutor(int corePoolSize,                  // 线程池的核心线程数量
         *                           int maximumPoolSize,               // 线程池的最大线程数
         *                           long keepAliveTime,                // 当线程数大于核心线程数时，多余的空闲线程存活的最长时间
         *                           TimeUnit unit,                     // 时间单位
         *                           BlockingQueue<Runnable> workQueue, // 任务队列，用来储存等待执行任务的队列
         *                           ThreadFactory threadFactory,       // 线程工厂，用来创建线程，一般默认即可
         *                           RejectedExecutionHandler handler   // 拒绝策略，当提交的任务过多而不能及时处理时，我们可以定制策略来处理任务
         *                           )
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 18; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("CurrentThread name:" + Thread.currentThread().getName() + "date：" + Instant.now());
            });
        }
        //终止线程池
        executor.shutdown();
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished all threads");
    }

}
