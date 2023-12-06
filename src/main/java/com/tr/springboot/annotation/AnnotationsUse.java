package com.tr.springboot.annotation;

import java.util.Date;

/**
 * 简单实现类
 *
 * @Author TR
 * @version 1.0
 * @date 8/19/2020 2:45 PM
 */
public class AnnotationsUse {

    @Annotations
    public void test() {
        System.out.println("---- 执行自定义注解 ----");
        System.out.println("执行自定义注解结束时间：" + new Date());

    }

}