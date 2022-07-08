package com.tr.springboot.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 消息监听者 Listener
 *  使用注解 @RabbitListener(queues = “message”) 来监听 message 的消息队列，@RabbitHandler 来实现具体消费
 *
 * @author TR
 * @version 1.0
 * @date 2020/8/25 下午7:33
 */
@Component
@RabbitListener(queues = "message") // @RabbitListener 注解定义该类对 message 队列的监听
public class Listener {

    @RabbitHandler // @RabbitHandler 注解来指定对消息的处理方法
    public void process(String messageContext) {
        if ("Sleep".equals(messageContext)) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Listener 接收消息：" + messageContext + "；时间：" + new Date());
    }

}
