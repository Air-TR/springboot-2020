package com.tr.springboot.designmode.factory;

/**
 * 测试类
 *
 * @author TR
 * @version 1.0
 * @date 8/24/2020 2:09 PM
 */
public class Test {

    public static void main(String[] args) {
        /** product = (M) Class.forName(cls.getName()).newInstance(); */
        ProductFactory factory = new ProductFactory();
        AbstractProduct productA = factory.createProduct(ProductA.class);
        productA.method();
        AbstractProduct productB = factory.createProduct(ProductB.class);
        productB.method();
        AbstractProduct productC = factory.createProduct(ProductC.class);
        productC.method();
    }

}
