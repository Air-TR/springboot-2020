package com.tr.springboot.thread;

import com.tr.springboot.thread.service.ThreadService;
import com.tr.springboot.thread.service.impl.ThreadServiceImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author TR
 * @version 1.0
 * @date 8/25/2020 10:58 AM
 */
public class Test {

    private static ThreadService threadService = new ThreadServiceImpl();

    public static void main(String[] args) {
        String a = threadService.methodA();
        String b = threadService.methodB();
        String c = threadService.methodC();
        System.out.println(a + b + c + "\n");

        new Thread(() -> threadService.methodA()).start();
        new Thread(() -> threadService.methodB()).start();
        new Thread(() -> threadService.methodC()).start();

    }

}
