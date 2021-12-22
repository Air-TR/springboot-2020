package com.tr.springboot.thread;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * 测试使用线程对速度的提升
 *
 * @author rtao
 * @date 2021/12/22 11:05
 */
public class TestThreadForSpeedUp {

    public static void main(String[] args) {
        System.out.println("Start ===> " + LocalTime.now());
        new Thread(() -> method1()).start();
        new Thread(() -> method2()).start();
        System.out.println("End ===> " + LocalTime.now());
    }

    private static void method1() {
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(">>>>> method1 end <<<<<");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void method2() {
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println(">>>>> method2 end <<<<<");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
