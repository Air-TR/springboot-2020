package com.tr.springboot.designmode.factory;

/**
 * 具体工厂类
 * 通过反射获取对象
 *
 * @Author TR
 * @version 1.0
 * @date 8/24/2020 2:08 PM
 */
public class ProductFactory extends AbstractFactory {

    @Override
    public <M extends AbstractProduct> M createProduct(Class<M> cls) {
        M product = null;
        try {
            //反射获取对象
            product = (M) Class.forName(cls.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }

}