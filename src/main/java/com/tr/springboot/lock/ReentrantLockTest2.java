package com.tr.springboot.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 锁测试：公平锁实现
 * https://baijiahao.baidu.com/s?id=1648624077736116382&wfr=spider&for=pc
 *
 * @Author TR
 * @version 1.0
 * @date 2020/8/16 下午6:33
 */
public class ReentrantLockTest2 {

    /**
     * ReentrantLock() 设置参数为true，表示为该锁为公平锁
     *                 默认 false，非公平锁
     */
    private static final Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        new Thread(() -> test(), "线程A").start();
        new Thread(() -> test(), "线程B").start();
        new Thread(() -> test(), "线程C").start();
        new Thread(() -> test(), "线程D").start();
        new Thread(() -> test(), "线程E").start();
    }

    public static void test() {
        for (int i = 0; i < 2; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获取了锁");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放了锁");
                lock.unlock();
            }
        }
    }
}
