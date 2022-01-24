//package com.tr.springboot.async;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author rtao
// * @date 2022/1/24 15:53
// */
//@RestController
//public class AsyncController {
//
//    @GetMapping("/async")
//    public void async() throws InterruptedException {
//        Thread.sleep(3000);
//        System.out.println(Thread.currentThread().getName() + ": async success");
//    }
//
//}
