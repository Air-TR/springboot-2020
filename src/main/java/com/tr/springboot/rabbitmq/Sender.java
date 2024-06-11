package com.tr.springboot.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 消息发送者 Sender
 *  使用 AmqpTemplate 将消息发送到消息队列 message 中去
 *
 * @Author TR
 * @version 1.0
 * @date 2020/8/25 下午7:31
 */
@Component
public class Sender {

    @Resource
    private AmqpTemplate amqpTemplate;

    public void send(String msg) {
        // 不设置消息持久化
        amqpTemplate.convertAndSend("message", msg);

        // 设置消息持久化
        amqpTemplate.convertAndSend("message", msg, msg, message -> {
            message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT); // 设置消息持久化
            return message;
        });

        System.out.println("Sender 发送消息：" + msg + "；时间：" + new Date());
    }

}
