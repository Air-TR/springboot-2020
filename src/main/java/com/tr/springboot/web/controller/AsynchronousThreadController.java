package com.tr.springboot.web.controller;

import com.tr.springboot.web.dao.jpa.AccountRepository;
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
    private AccountRepository accountRepository;

    @Resource
    private SleepService sleepService;

    @GetMapping("/asynchronous-thread/test")
    public String test() throws InterruptedException {
        long start = System.currentTimeMillis();
        String s = "";
        new Thread(() -> sleepService.sleep(1)).start();
//        new Thread(() -> sleepService.sleep(2)).start();
//        new Thread(() -> sleepService.sleep(3)).start();
//        s += accountRepository.getOne(1).getUsername();
//        s += accountRepository.getOne(2).getUsername();
//        s += accountRepository.getOne(3).getUsername();
//        s += accountRepository.getOne(4).getUsername();
//        s += accountRepository.getOne(5).getUsername();
//        s += accountRepository.getOne(6).getUsername();
//        s += accountRepository.getOne(7).getUsername();
//        s += accountRepository.getOne(8).getUsername();
//        s += accountRepository.getOne(9).getUsername();
//        s += accountRepository.getOne(10).getUsername();
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + " ms");
        return s;
    }

}
