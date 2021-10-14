package com.tr.springboot.aop.controller;

import com.tr.springboot.annotation.MethodTime;
import com.tr.springboot.annotation.TestMethodTime;
import com.tr.springboot.aop.service.AopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * AOP测试控制类
 * 其实实现AOP最基础的只需要aspect包下的LogAspect类即可
 *
 * @author TR
 * @version 1.0
 * @date 8/19/2020 9:55 AM
 */
@RestController
public class AopController {

    @Resource
    private AopService aopService;

    @Resource
    private TestMethodTime testMethodTime;

    /**
     * @Author: TR
     * http://localhost:8081/api/2020/aop/testAop
     */
    @GetMapping("/aop/testAop")
    public String hello() {
        return aopService.testAop();
    }

    // http://localhost:8081/api/2020/aop/test
    @GetMapping("/aop/test")
    public String test() {
//        int i = 1/0;
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

    // http://localhost:8081/api/2020/aop/methodTime2
    @GetMapping("/aop/methodTime2")
    public String methodTime2(){
        /**
         * 通过直接new对象的方式调用吗，test方法的 @MethodTime 不生效
         * 通过Bean注入的方式调用，test方法的 @MethodTime 生效
         */
//        TestMethodTime testMethodTime = new TestMethodTime();
        testMethodTime.test();
        return "Aop MethodTime";
    }

}
