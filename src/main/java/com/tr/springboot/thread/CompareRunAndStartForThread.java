package com.tr.springboot.thread;

import com.tr.springboot.thread.service.ThreadService;
import com.tr.springboot.thread.service.impl.ThreadServiceImpl;

/**
 * 比较对线程来说，通过 run 和 start 方法启动的区别
 *
 * @author TR
 * @version 1.0
 * @date 9/7/2020 4:53 PM
 */
public class CompareRunAndStartForThread {

    private static ThreadService threadService = new ThreadServiceImpl();

    /**
     * 放开 start()，先输出 sout，再输出 start() 方法里面内容
     * 放开 run()，先输出 run() 方法里面内容，后输出 sout
     *
     * 研究点就在于：
     *   start() 方法会起新线程，run() 方法不会，等于执行普通方法
     */
    public static void main(String[] args) {
        // 以下 4 行代码总执行时间 3 秒
        new Thread(() -> threadService.methodA()).start(); // 1 秒
        new Thread(() -> threadService.methodB()).start(); // 2 秒
        new Thread(() -> threadService.methodC()).start(); // 3 秒
        System.out.println("sout1"); // 先输出 "sout1"，再输出 start() 方法内容

        // 以下 4 行代码总执行时间 1 + 2 + 3 = 6 秒
        new Thread(() -> threadService.methodA()).run(); // 1 秒
        new Thread(() -> threadService.methodB()).run(); // 2 秒
        new Thread(() -> threadService.methodC()).run(); // 3 秒
        System.out.println("sout2"); // 先输出 run() 方法内容，再输出 "sout2"
    }

}
