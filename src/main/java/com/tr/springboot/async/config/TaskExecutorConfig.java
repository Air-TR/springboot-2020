package com.tr.springboot.async.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;

/**
 * @author taorun
 * @date 2023/2/3 10:57
 */
@Configuration
public class TaskExecutorConfig implements AsyncConfigurer {

    /** 核心线程数 */
    private static final int CORE_POOL_SIZE = 2;

    /** 最大线程数 */
    private static final int MAX_POOL_SIZE = 2;

    /** 工作队列容量（若采取直接拒绝策略，最多处理 max-pool-size + queue-capacity 个线程任务，多余任务直接拒绝）*/
    private static final int QUEUE_CAPACITY = 10;

    /**
     * 配置类实现 AsyncConfigurer 接口并重写 getAsyncExecutor 方法，返回一个 ThreadPoolTaskExecutor，
     * 这样就获得了一个基于线程池的 TaskExecutor
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        taskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        taskExecutor.setQueueCapacity(QUEUE_CAPACITY);
        taskExecutor.initialize();
        return taskExecutor;
    }

}