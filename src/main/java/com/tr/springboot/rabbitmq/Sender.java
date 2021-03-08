//package com.tr.springboot.rabbitmq;
//
//import org.apache.log4j.Logger;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.Date;
//
///**
// * 消息发送者Sender
// * 使用AmqpTemplate将消息发送到消息队列message中去
// *
// * @author TR
// * @version 1.0
// * @date 2020/8/25 下午7:31
// */
//@Component
//public class Sender {
//    Logger logger = Logger.getLogger(Sender.class);
//
//    @Resource
//    private AmqpTemplate amqpTemplate;
//
//    public String send() {
//        String context = "Test Message";
//        logger.info("发送消息：" + context + "  时间：" + new Date());
//        amqpTemplate.convertAndSend("message", context);
//        return "发送成功";
//    }
//}
