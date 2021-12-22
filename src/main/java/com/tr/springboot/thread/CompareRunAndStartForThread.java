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
        // 先输出 "sout"，再输出 start() 方法内容
        // 以下4行代码执行需要 3 秒
        new Thread(() -> threadService.methodA()).start();
        new Thread(() -> threadService.methodB()).start();
        new Thread(() -> threadService.methodC()).start();
        System.out.println("sout");

        // 先输出 start() 方法内容，再输出 "sout"
        // 以下4行代码执行需要 1+3+2 = 6 秒
//        new Thread(() -> threadService.methodA()).run();
//        new Thread(() -> threadService.methodB()).run();
//        new Thread(() -> threadService.methodC()).run();
//        System.out.println("sout");
    }

}
