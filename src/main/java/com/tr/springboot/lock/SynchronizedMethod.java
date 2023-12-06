package com.tr.springboot.lock;

import org.assertj.core.util.DateUtil;

import java.util.Date;

/**
 * Synchronized 修饰普通方法
 * 参考网址：https://blog.csdn.net/qq_38011415/article/details/89047812
 *
 * @Author TR
 * @version 1.0
 * @date 2020/8/13 下午11:49
 */
public class SynchronizedMethod implements Runnable {
    /**
     * 全局变量
     * 创建一个计数器
     */
    private static int counter = 1;

    /**
     * synchronized 修饰普通方法
     * 修饰方法和修饰一个代码块类似，只是作用范围不一样，修饰代码块是大括号括起来的范围，而修饰方法范围是整个函数。
     * 该类两个main()方法执行效果和 SynchronizedCode 类中一样（有一点不一样
     *      ———— SynchronizedCode 中两个线程输出的 startDate 一致，SynchronizedMethod 里两个线程不一致）
     */
    @Override
    public synchronized void run() {
        Date startDate = DateUtil.now();
        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("线程 ：" + Thread.currentThread().getName() + " 当前计数器 ：" + (counter++));
                System.out.println("开始时间 ：" + startDate + " 当前时间 ：" + DateUtil.now());
                System.out.println();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        main1();
//        main2();
    }

    /**
     * 当两个并发线程(thread1和thread2)访问同一个对象(syncThread)中的synchronized代码时
     * 同一时刻只能有一个线程得到执行，另一个线程受阻塞，必须等待当前线程执行完这个代码块以后才能执行该代码块。
     * Thread1和thread2是互斥的，因为在执行synchronized代码块时会锁定当前的对象，只有执行完该代码块才能释放该对象锁，下一个线程才能执行并锁定该对象。
     */
    public static void main1() {
        SynchronizedMethod syncThread = new SynchronizedMethod();
        Thread thread1 = new Thread(syncThread, "sync-thread-1");
        Thread thread2 = new Thread(syncThread, "sync-thread-2");
        thread1.start();
        thread2.start();
    }

    /**
     * 与上面有小改进，从执行结果看出：
     * 两个线程都是新建一个对象去执行，所以锁也是两个，所以执行方式是同时执行的。
     */
    public static void main2() {
        SynchronizedMethod syncThread1 = new SynchronizedMethod();
        SynchronizedMethod syncThread2 = new SynchronizedMethod();
        Thread thread1 = new Thread(syncThread1, "sync-thread-1");
        Thread thread2 = new Thread(syncThread2, "sync-thread-2");
        thread1.start();
        thread2.start();
    }


}
