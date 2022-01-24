package com.tr.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@SpringBootApplication
@MapperScan("com.tr.springboot.web.dao.mybatis")
@EnableScheduling
public class Springboot2020Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2020Application.class, args);
    }

}
