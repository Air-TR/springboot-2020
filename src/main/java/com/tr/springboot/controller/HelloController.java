package com.tr.springboot.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Hello")
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String first() {
        return "Hello 2020!";
    }

}
