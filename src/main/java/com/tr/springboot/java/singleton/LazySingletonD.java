package com.tr.springboot.java.singleton;

/**
 * 第四种线程安全的懒汉式单例(D)
 * 双重检测
 *
 * @author TR
 * @version 1.0
 * @date 2020/8/18 上午1:21
 */
public class LazySingletonD {

    //使用volatile关键字防止重排序，因为 new Instance()是一个非原子操作，可能创建一个不完整的实例
    private static volatile LazySingletonD singleton;

    private LazySingletonD() {
    }

    public static LazySingletonD getSingleton() {
        // Double-Check idiom
        if (singleton == null) {
            synchronized (LazySingletonD.class) {       // 1
                // 只需在第一次创建实例时才同步
                if (singleton == null) {       // 2
                    singleton = new LazySingletonD();      // 3
                }
            }
        }
        return singleton;
    }
}