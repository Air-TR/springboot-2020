package com.tr.springboot.aop.controller;

import com.tr.springboot.aop.service.AopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * AOP测试控制类
 * 其实实现AOP最基础的只需要aspect包下的LogAspect类即可
 *
 * @Author TR
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
//        int i = 1/0;
        System.out.println("AopController: /aop/test SUCCESS");
        return "/aop/test SUCCESS";
    }

    // http://localhost:8081/api/2020/aop/test-service
    @GetMapping("/aop/test-service")
    public String testService() {
        return aopService.testAop(); // 该方法配置了 @MethodTime 注解，会输出方法开始和结束时间
    }

}