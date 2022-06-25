package com.tr.springboot.resttemplate.controller;

import com.tr.springboot.web.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author TR
 * @date 2022/6/25 下午3:40
 */
@RestController
public class RestTemplateController {

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/rest/web/get/string")
    public String restWebGetString() {
        return restTemplate.getForObject("http://127.0.0.1:8080/web/get/string", String.class);
    }

    @GetMapping("/rest/web/advice/get/string")
    public Result restWebAdviceGetString() {
        return restTemplate.getForObject("http://127.0.0.1:8080/web/advice/get/string", Result.class);
    }

    @GetMapping("/rest/web/get")
    public HashMap restWebGet() {
        return restTemplate.getForObject("http://127.0.0.1:8080/web/get", HashMap.class);
    }

    @GetMapping("/rest/web/advice/get")
    public Result restWebAdviceGet() {
        return restTemplate.getForObject("http://127.0.0.1:8080/web/advice/get", Result.class);
    }

    @GetMapping("/rest/web/exception")
    public String restWebException() {
        return restTemplate.getForObject("http://127.0.0.1:8080/web/exception", String.class);
    }

    @GetMapping("/rest/web/advice/exception")
    public Result restWebAdviceException() {
        return restTemplate.getForObject("http://127.0.0.1:8080/web/advice/exception", Result.class);
    }

}
