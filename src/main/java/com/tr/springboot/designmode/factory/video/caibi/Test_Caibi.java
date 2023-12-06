//package com.tr.springboot.designmode.factory.video.caibi;
//
//import com.tr.springboot.designmode.factory.video.AbstractVideoFactory;
//import com.tr.springboot.designmode.factory.video.JavaVideo;
//import com.tr.springboot.designmode.factory.video.Video;
//
///**
// * 工厂方法比较Low的实现方式，对每个工厂实例单独创建，都这样了干嘛不直接New对象算了，还用什么工厂，不是多此一举
// * 客户端类，需要什么产品则通过该产品对应的工厂类来获取，不需要知道具体的创建过程
// *
// * @Author TR
// * @version 1.0
// * @date 8/24/2020 2:34 PM
// */
//public class Test_Caibi {
//
//    public static void main(String[] args) {
//        AbstractVideoFactory pythonVideoFactory = new PythonVideoFactory();
//        Video pythonVideo = pythonVideoFactory.getVideo();
//        pythonVideo.produce();
//
//        AbstractVideoFactory javaVideoFactory = new JavaVideoFactory();
//        Video javaVideo = javaVideoFactory.getVideo();
//        javaVideo.produce();
//
//        // 这样就可以实现干嘛要用工厂呢
//        Video jv = new JavaVideo();
//        jv.produce();
//
//        /**
//         * 当需要增加一个产品 FEVideo，
//         * 只需要增加 FEVideo 具体产品类和 FEVideoFactory 具体工厂类，不需要修改原有的产品类和工厂类
//         */
////        VideoFactory feVideoFactory = new FEVideoFactory();
////        Video feVideo = feVideoFactory.getVideo();
////        feVideo.produce();
//    }
//
//}
