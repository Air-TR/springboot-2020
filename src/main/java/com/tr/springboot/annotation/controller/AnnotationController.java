package com.tr.springboot.annotation.controller;

import com.tr.springboot.annotation.MethodTime;
import com.tr.springboot.annotation.TestMethodTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AnnotationController {

    @Resource
    private TestMethodTime testMethodTime;

    // http://localhost:8081/api/2020/aop/methodTime
    @GetMapping("/aop/methodTime")
    @MethodTime
    public String methodTime() {
        System.out.println("AopController: MethodTime");
        return "Aop MethodTime";
    }

    // http://localhost:8081/api/2020/aop/methodTime2
    @GetMapping("/aop/methodTime2")
    public String methodTime2() {
//        TestMethodTime testMethodTime = new TestMethodTime(); // 通过直接new对象的方式调用吗，test方法的 @MethodTime 不生效
        testMethodTime.test(); // 通过Bean注入的方式调用，test方法的 @MethodTime 生效
        return "Aop MethodTime2";
    }

}
