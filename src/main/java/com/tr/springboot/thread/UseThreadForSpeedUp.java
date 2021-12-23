package com.tr.springboot.thread;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * 测试使用线程对速度的提升
 *
 * @author rtao
 * @date 2021/12/22 11:05
 */
public class UseThreadForSpeedUp {

    public static void main(String[] args) throws InterruptedException {
        System.out.println();
        System.out.println("Start Running ===> " + LocalTime.now());
        String r = method3();
        System.out.println(r);
    }

    /**
     * method1  方法执行逻辑需要 5 秒
     * method2  方法执行逻辑需要 10 秒
     * method3  方法执行逻辑需要 1 秒
     * 整个 method3 方法结束时间仅需 1 秒，method1、method2 在后台自己运行
     */
    private static String method3() throws InterruptedException {
        new Thread(() -> method1()).start();
        new Thread(() -> method2()).start();
        TimeUnit.SECONDS.sleep(1);
        return "method3 over  ===> " + LocalTime.now();
    }

    private static void method1() {
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("method1 over  ===> " + LocalTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void method2() {
        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("method2 over  ===> " + LocalTime.now());
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
