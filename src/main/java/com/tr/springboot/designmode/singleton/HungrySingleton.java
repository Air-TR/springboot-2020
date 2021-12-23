package com.tr.springboot.designmode.singleton;

/**
 * 饿汉单例实例
 *  饿汉模式本身是线程安全的
 *
 * @author TR
 * @version 1.0
 * @date 2020/8/18 上午12:58
 */
public class HungrySingleton {

    // 指向自己实例的私有静态引用，主动创建
    private static HungrySingleton singleton = new HungrySingleton();

    // 私有的构造方法
    private HungrySingleton() {}

    // 以自己实例为返回值的静态的公有方法，静态工厂方法
    public static HungrySingleton getSingleton() {
        return singleton;
    }

}
