package com.tr.springboot.autorun;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 添加 @PostConstruct 注解的方法，会在项目启动时自动执行，也可理解为在 Spring 容器初始化的时候执行
 *
 * 该类与 AutoRunAfterSpringBootStart1 和 AutoRunAfterSpringBootStart2 的区别：
 *  被 @PostConstruct 注解的方法是在项目启动时执行，而不是启动后，上面两个类是在项目启动完成后才执行。
 *
 * @author: TR
 * @date: 2022/12/7 下午5:20
 */
@Component
public class PostConstructAutoRun {

    /**
     * 项目启动时会执行该方法，也可理解为在 Spring 容器初始化的时候执行该方法
     */
    @PostConstruct
    public void startRun() {
        System.out.println("项目启动时自动执行 --> PostConstructAutoRun.startRun()");
    }

}
