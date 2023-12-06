package com.tr.springboot.designmode.factory.video;

/**
 * @Author TR
 * @version 1.0
 * @date 8/24/2020 3:30 PM
 */
public class Test {

    public static void main(String[] args) {
        VideoFactory videoFactory = new VideoFactory();
        videoFactory.createVideo(JavaVideo.class).produce();
    }

}
