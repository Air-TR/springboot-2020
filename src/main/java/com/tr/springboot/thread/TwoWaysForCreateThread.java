package com.tr.springboot.thread;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * 创建线程的两种方式
 *
 * @author rtao
 * @date 2021/12/23 10:08
 */
public class TwoWaysForCreateThread {

    public static void main(String[] args) {
        System.out.println("main thread start ===> " + LocalTime.now());
        // 启动 ExtendsThread
        ExtendsThread extendsThread = new ExtendsThread();
        extendsThread.start();
        // 启动 ImplementsRunnableThread
        ImplementsRunnableThread implementsThread = new ImplementsRunnableThread();
        new Thread(implementsThread).start();
        System.out.println("main thread over  ===> " + LocalTime.now());
    }

}

class ExtendsThread extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("extends thread start ===> " + LocalTime.now());
            TimeUnit.SECONDS.sleep(3);
            System.out.println("extends thread over  ===> " + LocalTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class ImplementsRunnableThread implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("implements thread start ===> " + LocalTime.now());
            TimeUnit.SECONDS.sleep(5);
            System.out.println("implements thread over  ===> " + LocalTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
