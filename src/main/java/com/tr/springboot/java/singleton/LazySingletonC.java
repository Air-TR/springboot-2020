package com.tr.springboot.java.singleton;

/**
 * 第三种线程安全的懒汉式单例(C)
 * 同步延迟加载 — 使用内部类实现延迟加载
 *
 * @author TR
 * @version 1.0
 * @date 2020/8/18 上午1:19
 */
public class LazySingletonC {

    /**
     * 私有内部类，按需加载，用时加载，也就是延迟加载
     */
    private static class Holder {
        private static LazySingletonC singleton = new LazySingletonC();
    }

    private LazySingletonC() {
    }

    public static LazySingletonC getSingleton() {
        return Holder.singleton;
    }
}