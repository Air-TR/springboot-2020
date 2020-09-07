package com.tr.springboot.designmode.factory.video;

/**
 * 具体工厂类 VideoFactory，继承抽象工厂类 AbstractVideoFactory
 *
 * @author TR
 * @version 1.0
 * @date 8/24/2020 3:25 PM
 */
public class VideoFactory extends AbstractVideoFactory {

    @Override
    public Video getVideo() {
        return null;
    }

    /**
     * 这边的字母用 V 还是用什么都是随意的，原本是 T，用 V 只是因为 Video
     */
    @Override
    public <V extends Video> V createVideo(Class<V> cls) {
        V product = null;
        try {
            //反射获取对象
            product = (V) Class.forName(cls.getName()).newInstance();
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
