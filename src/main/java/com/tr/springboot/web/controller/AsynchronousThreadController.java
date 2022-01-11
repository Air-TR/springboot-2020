package com.tr.springboot.web.controller;

import com.tr.springboot.web.dao.jpa.AccountJpa;
import com.tr.springboot.web.service.SleepService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author TR
 * @version 1.0
 * @date 2020/9/9 下午10:28
 */
@Api(tags = "AsynchronousThread")
@RestController
public class AsynchronousThreadController {

    @Resource
    private AccountJpa accountJpa;

    @Resource
    private SleepService sleepService;

    @GetMapping("/asynchronous-thread/test")
    public String test() throws InterruptedException {
        long start = System.currentTimeMillis();
        String s = "";
        new Thread(() -> sleepService.sleep(1)).start();
//        new Thread(() -> sleepService.sleep(2)).start();
//        new Thread(() -> sleepService.sleep(3)).start();
//        s += accountJpa.getOne(1).getName();
//        s += accountJpa.getOne(2).getName();
//        s += accountJpa.getOne(3).getName();
//        s += accountJpa.getOne(4).getName();
//        s += accountJpa.getOne(5).getName();
//        s += accountJpa.getOne(6).getName();
//        s += accountJpa.getOne(7).getName();
//        s += accountJpa.getOne(8).getName();
//        s += accountJpa.getOne(9).getName();
//        s += accountJpa.getOne(10).getName();
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + " ms");
        return s;
    }

}
