package com.tr.springboot.aop.controller;

import com.tr.springboot.aop.annotation.MethodTime;
import com.tr.springboot.aop.service.AopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * AOP测试控制类
 *
 * @author TR
 * @version 1.0
 * @date 8/19/2020 9:55 AM
 */
@RestController
public class AopController {

    @Resource
    private AopService aopService;

    // http://localhost:8081/api/2020/aop/test
    @GetMapping("/aop/test")
    public String test() {
        System.out.println("AopController: AOP YES");
        return "AopController: AOP YES";
    }

    // http://localhost:8081/api/2020/aop/test-service
    @GetMapping("/aop/test-service")
    public String testService() {
        return aopService.testAop();
    }

    // http://localhost:8081/api/2020/aop/methodTime
    @GetMapping("/aop/methodTime")
    @MethodTime
    public String methodTime(){
        System.out.println("AopController: MethodTime");
        return "Aop MethodTime";
    }

}
