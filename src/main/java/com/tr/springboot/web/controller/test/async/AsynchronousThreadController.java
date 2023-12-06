package com.tr.springboot.web.controller.test.async;

import com.tr.springboot.web.dao.jpa.AccountJpa;
import com.tr.springboot.web.service.impl.SleepServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

/**
 * 异步线程控制类
 *
 * @Author TR
 * @version 1.0
 * @date 2020/9/9 下午10:28
 */
@Api(tags = "AsynchronousThread")
@RestController
public class AsynchronousThreadController {

    @Resource
    private AccountJpa accountJpa;

    @Resource
    private SleepServiceImpl sleepService;

    @GetMapping("/asynchronous-thread/test")
    public String test() throws InterruptedException {
        long start = System.currentTimeMillis();

        final CountDownLatch latch = new CountDownLatch(3);


        new Thread(() -> {
            sleepService.sleep(1);
            latch.countDown();
        }).start();
        new Thread(() -> {
            sleepService.sleep(1);
            latch.countDown();
        }).start();
        new Thread(() -> {
            sleepService.sleep(1);
            latch.countDown();
        }).start();

        latch.await();

//        new Thread(() -> sleepService.sleep(1)).start();
//        new Thread(() -> sleepService.sleep(2)).start();
//        new Thread(() -> sleepService.sleep(3)).start();

        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + " ms");

        return "success";
    }

}
