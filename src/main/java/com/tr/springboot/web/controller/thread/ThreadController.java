package com.tr.springboot.web.controller.thread;

import com.tr.springboot.thread.service.impl.ThreadServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalTime;
import java.util.concurrent.*;

/**
 * Thread 测试类
 *
 * @Author TR
 * @date 2022/9/1 上午9:20
 */
@RestController
public class ThreadController {

    @Resource
    ThreadServiceImpl threadService;

    /**
     * 执行输出结果：
     *  /countDownLatch ==> 10:10:46.619
     *  Finish A ==> 10:10:47.622
     *  Finish B ==> 10:10:48.623
     *  Finish C ==> 10:10:49.623
     *  End ==> 10:10:49.623
     *
     * 返回结果：
     *  End ==> 10:10:49.623
     *
     * 从结果看出：
     *  CountDownLatch 可以使主线程等待 start() 执行完成才继续执行和返回结果。
     *  countDownLatch.await(10, TimeUnit.SECONDS) 可以设置最大等待时间。
     */
    @GetMapping("/thread/CountDownLatch")
    public String countDownLatch() throws InterruptedException {
        System.out.println("/CountDownLatch ==> " + LocalTime.now());
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() -> {threadService.methodA(); countDownLatch.countDown();}).start();
        new Thread(() -> {threadService.methodB(); countDownLatch.countDown();}).start();
        new Thread(() -> {threadService.methodC(); countDownLatch.countDown();}).start();
        countDownLatch.await(10, TimeUnit.SECONDS); // timeout：最大等待时间
        System.out.println("End ==> " + LocalTime.now());
        return "End ==> " + LocalTime.now();
    }

    /**
     * 执行输出结果：
     *  /CyclicBarrier ==> 10:23:15.901
     *  Finish A ==> 10:23:16.906
     *  Finish B ==> 10:23:17.905
     *  Finish C ==> 10:23:18.906
     *  End ==> 10:23:18.906
     *
     * 返回结果：
     *  End ==> 10:23:18.906
     *
     * 从结果看出：
     *  CyclicBarrier 可以使主线程等待 start() 执行完成才继续执行和返回结果。
     *  cyclicBarrier.await(10, TimeUnit.SECONDS) 可以设置最大等待时间。
     *
     * 注意：
     *  new CyclicBarrier(int parties) ——— parties 要比实际新起线程数多 1。
     *  CountDownLatch 不需要，也就是 CyclicBarrier 比 CountDownLatch 要多配置 1。
     */
    @GetMapping("/thread/CyclicBarrier")
    public String cyclicBarrier() throws InterruptedException, BrokenBarrierException, TimeoutException {
        System.out.println("/CyclicBarrier ==> " + LocalTime.now());
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(4); // parties 要比实际新起线程数多 1
        new Thread(() -> {
            threadService.methodA();
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            threadService.methodB();
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            threadService.methodC();
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        cyclicBarrier.await(10, TimeUnit.SECONDS); // timeout：最大等待时间
        System.out.println("End ==> " + LocalTime.now());
        return "End ==> " + LocalTime.now();
    }

    /**
     * 执行输出结果：
     *  /start ==> 09:58:11.971
     *  End ==> 09:58:11.972
     *  Finish A ==> 09:58:12.975
     *  Finish B ==> 09:58:13.977
     *  Finish C ==> 09:58:14.973
     *
     * 返回结果：
     *  End ==> 09:58:11.972
     *
     * 从结果看出，start() 方法开启新的线程，且异步执行，后续代码及返回结果不会等新线程执行完毕。
     */
    @GetMapping("/thread/start")
    public String start() {
        System.out.println("/start ==> " + LocalTime.now());
        new Thread(() -> threadService.methodA()).start();
        new Thread(() -> threadService.methodB()).start();
        new Thread(() -> threadService.methodC()).start();
        System.out.println("End ==> " + LocalTime.now());
        return "End ==> " + LocalTime.now();
    }

    /**
     * 执行输出结果：
     *  /run ==> 10:01:37.215
     *  Finish A ==> 10:01:38.220
     *  Finish B ==> 10:01:40.224
     *  Finish C ==> 10:01:43.229
     *  End ==> 10:01:43.229
     *
     * 返回结果：
     *  End ==> 10:01:43.229
     *
     * 从结果看出，run() 方法不会开启新线程，不异步执行，后续代码及返回结果要等待 run() 执行完毕。
     */
    @GetMapping("/thread/run")
    public String run() {
        System.out.println("/run ==> " + LocalTime.now());
        new Thread(() -> threadService.methodA()).run();
        new Thread(() -> threadService.methodB()).run();
        new Thread(() -> threadService.methodC()).run();
        System.out.println("End ==> " + LocalTime.now());
        return "End ==> " + LocalTime.now();
    }

}
