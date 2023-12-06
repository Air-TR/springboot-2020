package com.tr.springboot.designmode.factory;

/**
 * 具体产品类 ProductB，继承抽象产品类 AbstractProduct
 *
 * @Author TR
 * @version 1.0
 * @date 8/24/2020 2:06 PM
 */
public class ProductB extends AbstractProduct {

    @Override
    public void method() {
        System.out.println("ProductB method logic.");
    }

}