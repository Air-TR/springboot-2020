package com.tr.springboot.lock;

import org.assertj.core.util.DateUtil;

import java.util.Date;

/**
 * Synchronized 修饰静态方法
 * 参考网址：https://blog.csdn.net/qq_38011415/article/details/89047812
 *
 * @author TR
 * @version 1.0
 * @date 2020/8/13 下午11:59
 */
public class SynchronizedStaticMethod implements Runnable {

    private static int counter = 1;

    /**
     * Synchronized 修饰 静态的同步方法
     */
    public synchronized static void method() {
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

    @Override
    public void run() {
        method();
    }

    /**
     * syncThread1和syncThread2是SyncThread的两个对象，但在thread1和thread2并发执行时却保持了线程同步。
     * 这是因为run中调用了静态方法method，而静态方法是属于同一类的，所以syncThread1和syncThread2相当于用了同一把锁。
     *
     * 注：实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制
     */
    public static void main(String[] args) {
        SynchronizedStaticMethod syncThread1 = new SynchronizedStaticMethod();
        SynchronizedStaticMethod syncThread2 = new SynchronizedStaticMethod();
        Thread thread1 = new Thread(syncThread1, "sync-thread-1");
        Thread thread2 = new Thread(syncThread2, "sync-thread-2");
        thread1.start();
        thread2.start();
    }

}
