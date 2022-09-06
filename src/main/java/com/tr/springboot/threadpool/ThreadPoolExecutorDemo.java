package com.tr.springboot.threadpool;

import java.time.Instant;
import java.time.LocalTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ThreadPoolExecutor 使用示例
 *
 * @author TR
 * @date 8/25/2020 2:17 PM
 */
public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final int QUEUE_CAPACITY = 10;
    private static final long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start ==> " + LocalTime.now());

        /**
         * 阿里巴巴推荐的创建线程池的方式
         * 通过 ThreadPoolExecutor 构造函数自定义参数创建
         * public ThreadPoolExecutor(int corePoolSize,                  // 线程池的核心线程数量
         *                           int maximumPoolSize,               // 线程池的最大线程数
         *                           long keepAliveTime,                // 当线程数大于核心线程数时，多余的空闲线程存活的最长时间
         *                           TimeUnit unit,                     // 时间单位
         *                           BlockingQueue<Runnable> workQueue, // 任务队列，用来储存等待执行任务的队列
         *                           ThreadFactory threadFactory,       // 线程工厂，用来创建线程，一般默认即可
         *                           RejectedExecutionHandler handler   // 拒绝策略，当提交的任务过多而不能及时处理时，我们可以定制策略来处理任务
         *                           )
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        int taskNum = 5; // 要执行的线程任务数
        CountDownLatch countDownLatch = new CountDownLatch(taskNum); // 要实现同步配置这个，异步不需要

        for (int i = 0; i < taskNum; i++) {
            int count = i + 1;
            threadPoolExecutor.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(count + " -> CurrentThread Name: " + Thread.currentThread().getName() + " ==> " + LocalTime.now());
                countDownLatch.countDown(); // 要实现同步配置这个，异步不需要
            });
//            threadPoolExecutor.submit(() -> {
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(count + " -> CurrentThread Name: " + Thread.currentThread().getName() + " ==> " + LocalTime.now());
////                countDownLatch.countDown(); // 要实现同步配置这个，异步不需要
//            });
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
        threadPoolExecutor.shutdown();

        System.out.println("End ==> " + LocalTime.now());
    }

}
