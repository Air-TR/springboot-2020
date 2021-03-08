//package com.tr.springboot.rabbitmq;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
///**
// * @author TR
// * @version 1.0
// * @date 2020/8/25 下午7:38
// */
//@RestController
//public class RabbitMQController {
//
//    @Resource
//    private Sender sender;
//
//    @GetMapping("/mq/hello")
//    public String helloTest(){
//        sender.send();
//        return "Rabbit Success!";
//    }
//
//}
