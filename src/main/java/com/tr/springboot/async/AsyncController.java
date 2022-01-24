package com.tr.springboot.async;

import com.tr.springboot.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异步测试类
 *
 * @author rtao
 * @date 2022/1/24 15:53
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/async")
    public void async() {
        System.out.println("start");
        asyncService.async();
        System.out.println("end");
    }

}
