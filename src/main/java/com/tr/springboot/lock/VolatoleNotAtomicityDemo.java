package com.tr.springboot.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 证明 volatile 不保证原子性代码（理应输出 5000，但实际运行结果可能小于 5000）
 *
 * 本类代码详解及如何修改使本类代码能保证原子性见：有道云笔记 - 并发/关键字/volatile 关键字
 *
 * @author TR
 * @date 2022/9/19 下午2:43
 */
public class VolatoleNotAtomicityDemo {

    public volatile static int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        VolatoleNotAtomicityDemo volatoleAtomicityDemo = new VolatoleNotAtomicityDemo();
        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    volatoleAtomicityDemo.increase();
                }
            });
        }
        // 等待 2 秒，保证上面程序执行完成
        Thread.sleep(2000);
        System.out.println(inc);
        threadPool.shutdown();
    }

}
