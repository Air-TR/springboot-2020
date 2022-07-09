package com.tr.springboot.web.controller.advice;

import com.tr.springboot.web.common.annotation.NotControllerResponseAdvice;
import com.tr.springboot.web.common.result.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 该类中的接口，会被 ControllerResponseAdvice 扫描，自动将返回结果封装成 Result 类型返回
 *
 * @author TR
 * @date 2022/6/25 上午9:42
 */
@Api(tags = "Advice")
@RestController
public class AdviceController {

    /**
     * 即使返回类型是 void，也会被封装成 Result 类型返回：{ "code": 0, "msg": "成功", "data": null }
     */
    @GetMapping("/advice/void")
    public void voidApi() {}

    /**
     * 该接口返回结果会被自动包装成 Result 类型返回
     */
    @GetMapping("/advice/get/string")
    public String getString() {
        return "SUCCESS";
    }

    /**
     * 该接口返回结果会被自动包装成 Result 类型返回
     */
    @GetMapping("/advice/get")
    public HashMap get() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "Jack");
        hashMap.put("age", 23);
        return hashMap;
    }

    /**
     * 配置了 @NotControllerResponseAdvice 注解的接口，会被 ControllerResponseAdvice 忽略，不将返回结果包装成 Result 类型
     */
    @GetMapping("/advice/get/notAdvice")
    @NotControllerResponseAdvice
    public HashMap notAdvice() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "Jack");
        hashMap.put("age", 23);
        return hashMap;
    }

    /**
     * 已经是 Result 类型的返回结果，也会被 ControllerResponseAdvice 忽略，不会再进行包装
     */
    @GetMapping("/advice/get/result")
    public Result getResult() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "Jack");
        hashMap.put("age", 23);
        return Result.success(hashMap);
    }

    /**
     * 该接口返回结果会被自动包装成 Result 类型返回
     */
    @GetMapping("/advice/exception")
    public void exception() {
        int i = 1 / 0; // 制造异常
    }

}
