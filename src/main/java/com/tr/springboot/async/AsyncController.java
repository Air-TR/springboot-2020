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
    public String async() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(500);
        asyncService.voidAsync(); // 异步执行
        String res = asyncService.returnAsync(); // 异步执行
        System.out.println(res); // 输出结果为 null
        long end = System.currentTimeMillis();
        return "执行：" + (end - start) + "ms";
    }

    /**
     * 该方法执行不会有返回内容，事实上返回的是 null
     */
    @GetMapping("/async2")
    public String async2() {
        return asyncService.returnAsync();
    }

}
