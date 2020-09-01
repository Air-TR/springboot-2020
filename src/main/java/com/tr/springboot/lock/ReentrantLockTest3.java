package com.tr.springboot.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * https://baijiahao.baidu.com/s?id=1648624077736116382&wfr=spider&for=pc
 *
 * @author TR
 * @version 1.0
 * @date 2020/8/16 下午6:46
 */
public class ReentrantLockTest3 {

    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread thread0 = new Thread(new ThreadDemo(lock1, lock2));
        Thread thread1 = new Thread(new ThreadDemo(lock2, lock1));
        thread0.start();
        thread1.start();
//        thread0.interrupt();
    }

    static class ThreadDemo implements Runnable {
        Lock lock1;
        Lock lock2;
        public ThreadDemo(Lock lock1, Lock lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        /**
         * 使用这段代码
         * 注释掉main方法中 thread0.interrupt(); 会出现死锁
         * 放开main方法中 thread0.interrupt(); 不会出现死锁
         * thread0.interrupt(); 中断了线程0,使得线程1得到资源正常结束
         *
         * lock() 与 lockInterruptibly() 比较区别在于：
         * lock() 优先考虑获取锁，待获取锁成功后，才响应中断。
         * lockInterruptibly() 优先考虑响应中断，而不是响应锁的普通获取或重入获取。
         */
//        @Override
//        public void run() {
//            try {
//                lock1.lockInterruptibly();
//                TimeUnit.MILLISECONDS.sleep(1000);
//                lock2.lockInterruptibly();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                lock1.unlock();
//                lock2.unlock();
//                System.out.println(Thread.currentThread().getName() + "获取到了资源，正常结束。");
//            }
//        }

        @Override
        public void run() {
            try {
                if (!lock1.tryLock()) {
                    TimeUnit.MILLISECONDS.sleep(1000);
                }
                if (!lock2.tryLock()) {
                    TimeUnit.MILLISECONDS.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
                lock2.unlock();
                System.out.println(Thread.currentThread().getName() + "正常结束");
            }
        }
    }

}
