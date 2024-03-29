package com.tr.springboot.autorun;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * run()方法会在 SpringBoot 启动后自动执行
 *
 * @author rtao
 * @date 2021/8/17 11:10
 */
@Component
public class AutoRunAfterSpringBootStart1 implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        // todo (从数据库获取任务数据，并实现定时触发执行)
        System.out.println("项目启动后自动执行 --> AutoRunAfterSpringBootStart1.run()");
    }

}
