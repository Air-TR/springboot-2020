package com.tr.springboot.web.controller;

import com.tr.springboot.web.service.ApiLogService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author taorun
 * @date 2023/1/11 18:20
 */
@Api(tags = "ApiLog")
@RestController
public class ApiLogAspectController {

    @Resource
    private ApiLogService apiLogService;

    @GetMapping("/apiLog")
    public String apiLog(String name, Integer age) {
        return apiLogService.apiLog(name, age);
    }

}
