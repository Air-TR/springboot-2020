package com.tr.springboot.annotation;

import org.springframework.stereotype.Component;

/**
 * 使用自定义注解 @Annotations 的类
 *
 * @author TR
 * @version 1.0
 * @date 8/19/2020 2:47 PM
 */
@Component
public class TestMethodTime {

    @MethodTime
    public void test() {
        System.out.println("TestMethodTime YES!");
    }

}