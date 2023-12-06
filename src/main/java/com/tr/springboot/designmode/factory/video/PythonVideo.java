package com.tr.springboot.designmode.factory.video;

/**
 * 具体产品类 PythonVideo，继承抽象产品类 Video
 *
 * @Author TR
 * @version 1.0
 * @date 8/24/2020 2:20 PM
 */
public class PythonVideo extends Video {

    @Override
    public void produce() {
        System.out.println("录制Python课程视频");
    }

}