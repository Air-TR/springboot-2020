package com.tr.springboot.threadpool.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author TR
 * @date 2022/9/1 下午2:55
 */
@Configuration
public class ThreadPoolTaskExecutorConfig {

    /** 核心线程数 */
    @Value("${thread.pool.core-pool-size}")
    private int corePoolSize;

    /** 最大线程数 */
    @Value("${thread.pool.max-pool-size}")
    private int maxPoolSize;

    /** 工作队列容量 */
    @Value("${thread.pool.queue-capacity}")
    private int queueCapacity;

    /** 线程池维护线程所允许的空闲时间 */
    @Value("${thread.pool.keep-alive-seconds}")
    private int keepAliveSeconds;

    /** 拒绝策略 */
    @Value("${thread.pool.rejected-execution-handler}")
    private String rejectedExecutionHandler;

    @Value("${thread.pool.waitForJobsToCompleteOnShutdown}")
    private Boolean waitForJobsToCompleteOnShutdown;

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
        threadPoolTaskExecutor.setQueueCapacity(queueCapacity);
        threadPoolTaskExecutor.setKeepAliveSeconds(keepAliveSeconds);

        /**
         * 该方法用来设置线程池关闭的时候，等待所有任务都完成后，再销毁其他的 Bean，这样这些异步任务的销毁，就会先于数据库连接池对象的销毁。
         * 默认 false
         */
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(waitForJobsToCompleteOnShutdown);

        try {
            // 反射加载拒绝策略类
            Class clazz = Class.forName("java.util.concurrent.ThreadPoolExecutor$" + rejectedExecutionHandler);
            threadPoolTaskExecutor.setRejectedExecutionHandler((RejectedExecutionHandler) clazz.newInstance());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            // 默认使用 CallerRunsPolicy 策略：直接在 execute 方法的调用线程中运行被拒绝的任务
            threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        }

        threadPoolTaskExecutor.initialize(); // 此步必要
        return threadPoolTaskExecutor;
    }

}
