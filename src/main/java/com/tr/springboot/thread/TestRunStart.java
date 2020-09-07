package com.tr.springboot.thread;

import com.tr.springboot.thread.service.ThreadService;
import com.tr.springboot.thread.service.impl.ThreadServiceImpl;

/**
 * @author TR
 * @version 1.0
 * @date 9/7/2020 4:53 PM
 */
public class TestRunStart {

    private static ThreadService threadService = new ThreadServiceImpl();

    /**
     * 放开 start()，先输出 sout，再输出 start() 方法里面内容
     * 放开 run()，先输出 run() 方法里面内容，后输出 sout
     *
     * 研究点就在于：
     *   start() 方法会起新线程，run() 方法不会，等于执行普通方法
     */
    public static void main(String[] args) {
        new Thread(() -> threadService.methodA()).start();
//        new Thread(() -> threadService.methodA()).run();
        System.out.println("sout");
    }

}
