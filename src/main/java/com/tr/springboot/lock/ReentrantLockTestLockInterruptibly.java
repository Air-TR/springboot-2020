package com.tr.springboot.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock：测试 lockInterruptibly() 方法
 * https://www.bbsmax.com/A/kmzLb8Mb5G/
 *
 * @Author TR
 * @version 1.0
 * @date 2020/8/16 下午7:35
 */
public class ReentrantLockTestLockInterruptibly {

    private Lock lock = new ReentrantLock();

    public void doBusiness() {
        String name = Thread.currentThread().getName();

        try {
            System.out.println(name + " 开始获取锁");
            /**
             * 测试结果：
             * lockInterruptibly()，使用 interrupt() 能中断正在等待获取锁的线程
             * lock()，使用 interrupt() 不能中断正在等待获取锁的线程，只能中断已经获得锁的线程
             */
//            lock.lock();
            lock.lockInterruptibly();
            System.out.println(name + " 得到锁");
            System.out.println(name + " 开工干活");
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println(name + " : " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " 被中断");
            System.out.println(name + " 做些别的事情");
        } finally {
            try {
                lock.unlock();
                System.out.println(name + " 释放锁");
            } catch (Exception e) {
                System.out.println(name + " : 没有得到锁的线程运行结束");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ReentrantLockTestLockInterruptibly lockTest = new ReentrantLockTestLockInterruptibly();

        Thread t0 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        lockTest.doBusiness();
                    }
                }
        );

        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        lockTest.doBusiness();
                    }
                }
        );

        // 启动线程t1
        t0.start();
//        Thread.sleep(10);
        // 启动线程t2
        t1.start();
//        Thread.sleep(100);
        // 线程t1没有得到锁，中断t1的等待
        t1.interrupt();
    }

}
