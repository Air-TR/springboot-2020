package com.tr.springboot.threadpool.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author TR
 * @date 2022/9/1 下午3:49
 */
@Configuration
public class ThreadPoolExecutorConfig {

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

    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveSeconds,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueCapacity),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        return threadPoolExecutor;
    }

}
