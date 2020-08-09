package com.tr.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tr.springboot.dao.mybatis")
public class Springboot2020Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2020Application.class, args);
    }

}
