//package com.tr.springboot.rabbitmq;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.Date;
//
///**
// * @Author TR
// * @version 1.0
// * @date 2020/8/25 下午7:38
// */
//@RestController
//public class RabbitMQController {
//
//    @Resource
//    private Sender sender;
//
//    @GetMapping("/mq/test")
//    public String mqTest() {
//        sender.send("MQ Message");
//        return "MQ Test Success";
//    }
//
//    /**
//     * 通过 RabbitMQ 实现异步
//     */
//    @GetMapping("/mq/async")
//    public String mqSlow() {
//        System.out.println("Start Time: " + new Date());
//        sender.send("Sleep"); // 这边会发送一个消息去执行一个需要 3 秒执行完毕的方法，下面的返回却不需要等 3 秒，会直接返回
//        return "Return Time: " + new Date();
//    }
//
//}
