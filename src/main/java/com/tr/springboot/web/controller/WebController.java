package com.tr.springboot.web.controller;

import com.tr.springboot.web.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 普通接口类，与 AdviceController 做对比
 *  该类中的接口，不被 ControllerResponseAdvice 扫描，不会自动将返回结果包装成 Result 类型
 *
 * @Author TR
 * @date 2022/6/24 下午6:11
 */
@RestController
public class WebController {

    @GetMapping("/get/string")
    public String getString() {
        return "SUCCESS";
    }

    @GetMapping("/get")
    public HashMap get() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "Jack");
        hashMap.put("age", 23);
        return hashMap;
    }

    @GetMapping("/get/result")
    public Result getResult() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "Jack");
        hashMap.put("age", 23);
        return Result.success(hashMap);
    }

    @GetMapping("/exception")
    public void exception() {
        int i = 1 / 0; // 制造异常
    }

}
