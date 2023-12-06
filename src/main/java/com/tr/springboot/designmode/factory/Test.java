package com.tr.springboot.designmode.factory;

/**
 * 测试类
 *
 * 工厂模式实现：
 * 1.创建抽象产品类
 * 2.创建抽象工厂类
 * 3.创建实体产品类（继承抽象产品类），多个，内部实现各自重写的方法功能
 * 4.创建实体工厂类（继承抽象工厂类），一个，通过反射获取需要创建的具体产品对象
 *
 * @Author TR
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
