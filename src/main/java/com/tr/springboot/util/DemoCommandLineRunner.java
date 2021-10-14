package com.tr.springboot.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * run()方法会在 SpringBoot 启动后自动执行
 *
 * @author rtao
 * @date 2021/8/17 11:23
 */
@Component
public class DemoCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // todo (从数据库获取任务数据，并实现定时触发执行)
    }

}