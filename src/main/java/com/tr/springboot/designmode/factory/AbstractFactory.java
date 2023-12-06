package com.tr.springboot.designmode.factory;

/**
 * 抽象工厂类
 *
 * @Author TR
 * @version 1.0
 * @date 8/24/2020 2:06 PM
 */
public abstract class AbstractFactory {

    public abstract <M extends AbstractProduct> M createProduct(Class<M> cls);

}