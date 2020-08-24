package com.tr.springboot.designmode.factory.video;

/**
 * 抽象工厂类 AbstractVideoFactory
 *
 * @author TR
 * @version 1.0
 * @date 8/24/2020 2:26 PM
 */
public abstract class AbstractVideoFactory {

    public abstract Video getVideo();

    public abstract <V extends Video> V createVideo(Class<V> cls);

}