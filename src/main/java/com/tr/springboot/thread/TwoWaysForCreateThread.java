package com.tr.springboot.thread;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * 创建线程的两种方式
 *  1.继承 Thread 类，重写 run() 方法
 *  2.实现 Runnable 接口，重写 run() 方法
 *
 * @author rtao
 * @date 2021/12/23 10:08
 */
public class TwoWaysForCreateThread {

    public static void main(String[] args) {
        System.out.println("main thread start ===> " + LocalTime.now());

        /** 继承 Thread 类 */
        ExtendsThread extendsThread = new ExtendsThread();
        extendsThread.start();

        /** 实现 Runnable 接口 */
        ImplementsRunnableThread implementsThread = new ImplementsRunnableThread();
        new Thread(implementsThread).start();

        System.out.println("main thread over  ===> " + LocalTime.now());
    }

}

/**
 * 1.继承 Thread 类，重写 run() 方法
 */
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

/**
 * 2.实现 Runnable 接口，重写 run() 方法
 */
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
