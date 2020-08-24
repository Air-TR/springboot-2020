package com.tr.springboot.designmode.factory;

/**
 * 具体产品类 ProductA，继承抽象产品类 AbstractProduct
 *
 * @author TR
 * @version 1.0
 * @date 8/24/2020 2:04 PM
 */
public class ProductA extends AbstractProduct {

    @Override
    public void method() {
        System.out.println("ProductA method logic.");
    }

}