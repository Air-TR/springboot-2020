package com.tr.springboot.java.singleton;

/**
 * 第二种线程安全的懒汉式单例(B)
 * 同步延迟加载 — synchronized块
 *
 * @author TR
 * @version 1.0
 * @date 2020/8/18 上午1:15
 */
public class LazySingletonB {

    private static LazySingletonB singleton;

    private LazySingletonB() {
    }

    public static LazySingletonB getSingleton() {
        /**
         * 使用 synchronized 块，临界资源的同步互斥访问
         */
        synchronized (LazySingletonB.class) {
            if (singleton == null) {
                singleton = new LazySingletonB();
            }
        }
        return singleton;
    }
}