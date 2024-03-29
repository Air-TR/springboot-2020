package com.tr.springboot.lock;

import java.util.concurrent.TimeUnit;

/**
 * Volatile ：保证内存可见性；禁止指令重排序
 * https://blog.csdn.net/tomcyndi/article/details/79094324
 *
 * @Author TR
 * @version 1.0
 * @date 8/17/2020 10:52 AM
 */
public class VolatileTest extends Thread {

    /**
     * volatile 修饰的变量，修改结果对其他线程可见（线程间可见，主内存、CPU 缓存）
     */
    volatile int x = 0; // 此处可以将 volatile 去除或者替换为 static，经过对比可看出 volatile 的作用

    private void write() {
        x = 5;
    }

    private void read() {
        while (x != 5) {
//            System.out.println("false"); // 此处放开也会导致修改可读，应该是执行 System.out.println 的时候 JVM 有什么资源分配导致，不确定
        }
        if (x == 5) {
            System.out.println("------stoped");
        }
    }

    public static void main(String[] args) throws Exception {
        VolatileTest volatileTest = new VolatileTest();

        Thread writeThread = new Thread(new Runnable() {
            public void run() {
                volatileTest.write();
            }
        });

        Thread readThread = new Thread(new Runnable() {
            public void run() {
                volatileTest.read();
            }
        });

        readThread.start();
        System.out.println("------");
        TimeUnit.SECONDS.sleep(2); // 此处一定要暂停一段时间，以保证 writeThread 一定会在 readThread 中执行
        writeThread.start();
    }

}