package com.tr.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 注：
 *  1.如果 RabbitMQ 服务没有启动，需要将 rabbitmq 包下的类注释掉，否则启动会一直报 RabbitMQ 链接错误 Connection refused (Connection refused)。
 */
@EnableAsync
@SpringBootApplication
@MapperScan("com.tr.springboot.web.dao.mybatis")
@EnableScheduling
public class Springboot2020Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2020Application.class, args);
    }

}
