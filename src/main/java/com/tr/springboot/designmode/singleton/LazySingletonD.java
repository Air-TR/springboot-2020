package com.tr.springboot.designmode.singleton;

/**
 * 第四种线程安全的懒汉式单例(D)
 *
 * 双重校验锁实现单例模式
 *
 * @Author TR
 * @version 1.0
 * @date 2020/8/18 上午1:21
 */
public class LazySingletonD {

    // 使用 volatile 关键字防止重排序，因为 new Instance() 是一个非原子操作，可能创建一个不完整的实例
    private static volatile LazySingletonD singleton;

    private LazySingletonD() {
    }

    public static LazySingletonD getSingleton() {
        // 先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (singleton == null) {
            // 类对象加锁
            synchronized (LazySingletonD.class) {
                // 只需在第一次创建实例时才同步
                if (singleton == null) {
                    singleton = new LazySingletonD();
                }
            }
        }
        return singleton;
    }

}