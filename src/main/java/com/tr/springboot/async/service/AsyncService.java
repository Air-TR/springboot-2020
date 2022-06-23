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
    public void voidAsync() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async // 使用 @Async 需要在启动类配置 @EnableAsync
    public String returnAsync() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ASYNC SUCCESS";
    }

}
