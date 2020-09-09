package com.tr.springboot.thread;

import com.tr.springboot.thread.service.ThreadService;
import com.tr.springboot.thread.service.impl.ThreadServiceImpl;
import com.tr.springboot.web.entity.Account;

/**
 * @author TR
 * @version 1.0
 * @date 8/25/2020 10:58 AM
 */
public class Test {

    private static ThreadService threadService = new ThreadServiceImpl();

    public static void main(String[] args) throws InterruptedException {
//        String a = threadService.methodA();
//        String b = threadService.methodB();
//        String c = threadService.methodC();
//        System.out.println(a + b + c + "\n");

        Account account = new Account();

        Thread t1 = new Thread(() -> {
            account.setUsername(account.getUsername() + threadService.methodA());
            System.out.println("T1 - Username: " + account.getUsername());
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            account.setUsername(account.getUsername() + threadService.methodB());
            System.out.println("T2 - Username: " + account.getUsername());
        });
        t2.start();

        Thread t3 = new Thread(() -> {
            account.setUsername(account.getUsername() + threadService.methodC());
            System.out.println("T3 - Username: " + account.getUsername());
        });
        t3.start();
        t3.join();

        System.out.println("Username: " + account.getUsername());


//        new Thread(() -> threadService.methodA()).start();
//        new Thread(() -> threadService.methodB()).start();
//        new Thread(() -> threadService.methodC()).start();

    }

}
