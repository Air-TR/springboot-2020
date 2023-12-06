package com.tr.springboot.designmode.singleton;

/**
 * 第五种线程安全的懒汉式单例(E)
 * ThreadLocal
 * 
 * @Author TR
 * @version 1.0
 * @date 2020/8/18 上午1:22
 */
public class LazySingletonE {

    /**
     * ThreadLocal 线程局部变量，将单例 instance 线程私有化
     */
    private static ThreadLocal<LazySingletonE> threadlocal = new ThreadLocal<LazySingletonE>();

    private static LazySingletonE instance;

    private LazySingletonE() {

    }

    public static LazySingletonE getInstance() {
        // 第一次检查：若线程第一次访问，则进入 if 语句块；否则，若线程已经访问过，则直接返回 ThreadLocal 中的值
        if (threadlocal.get() == null) {
            synchronized (LazySingletonE.class) {
                if (instance == null) { // 第二次检查：该单例是否被创建
                    instance = new LazySingletonE();
                }
            }
            threadlocal.set(instance); // 将单例放入ThreadLocal中
        }
        return threadlocal.get();
    }
}