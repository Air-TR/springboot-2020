package com.tr.springboot.java.singleton;

/**
 * 第一种线程安全的懒汉式单例(A)
 * 同步延迟加载 — synchronized方法
 *
 * @author TR
 * @version 1.0
 * @date 2020/8/18 上午1:13
 */
public class LazySingletonA {

    private static LazySingletonA singleton;

    private LazySingletonA() {
    }

    /**
     * 使用 synchronized 修饰，临界资源的同步互斥访问
     */
    public static synchronized LazySingletonA getSingleton() {
        if (singleton == null) {
            singleton = new LazySingletonA();
        }
        return singleton;
    }
}