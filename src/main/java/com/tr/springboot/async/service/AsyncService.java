package com.tr.springboot.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author TR
 * @date 2022/1/24 下午6:46
 */
@Service
public class AsyncService {

    @Async // 使用 @Async 需要在启动类配置 @EnableAsync
    public void async() {
        try {
            System.out.println(Thread.currentThread().getName() + ": async start");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + ": async end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async // 使用 @Async 需要在启动类配置 @EnableAsync
    public String async2() {
        try {
            System.out.println(Thread.currentThread().getName() + ": async start 2");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + ": async end 2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ASYNC OVER";
    }

}
