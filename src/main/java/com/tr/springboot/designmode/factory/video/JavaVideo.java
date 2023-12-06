package com.tr.springboot.designmode.factory.video;

/**
 * 具体产品类 JavaVideo，继承抽象产品类 Video
 *
 * @Author TR
 * @version 1.0
 * @date 8/24/2020 2:19 PM
 */
public class JavaVideo extends Video {

    @Override
    public void produce() {
        System.out.println("录制Java课程视频");
    }

}