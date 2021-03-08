//package com.tr.springboot.rabbitmq;
//
//import org.apache.log4j.Logger;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
///**
// * 消息接收者 Receiver
// * 使用注解@RabbitListener(queues = “message”)来监听message的消息队列，@RabbitHandler来实现具体消费。
// *
// * @author TR
// * @version 1.0
// * @date 2020/8/25 下午7:33
// */
//@Component
//@RabbitListener(queues = "message") // @RabbitListener注解定义该类对 message 队列的监听
//public class Receiver {
//    Logger logger = Logger.getLogger(Receiver.class);
//
//    @RabbitHandler // @RabbitHandler注解来指定对消息的处理方法
//    public void process(String messageContext) {
//        logger.info("接收消息：" + messageContext + "  时间：" + new Date());
//    }
//}