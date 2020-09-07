package com.tr.springboot.designmode.singleton;

/**
 * 懒汉单例实例（非线程安全）
 *
 * @author TR
 * @version 1.0
 * @date 2020/8/18 上午1:01
 */
public class LazySingleton {

    // 指向自己实例的私有静态引用
    private static LazySingleton singleton;

    // 私有的构造方法
    private LazySingleton() {
    }

    // 以自己实例为返回值的静态的公有方法，静态工厂方法
    public static LazySingleton getSingleton() {
        // 被动创建，在真正需要使用时才去创建
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }
}