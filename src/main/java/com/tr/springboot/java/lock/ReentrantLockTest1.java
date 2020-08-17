package com.tr.springboot.java.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 锁测试
 * https://baijiahao.baidu.com/s?id=1648624077736116382&wfr=spider&for=pc
 *
 * @author TR
 * @version 1.0
 * @date 2020/8/16 下午5:52
 */
public class ReentrantLockTest1 {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> test(), "线程A").start();
        new Thread(() -> test(), "线程B").start();
    }

    public static void test() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "获取了锁");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放了锁");
            lock.unlock();
        }
    }

}
