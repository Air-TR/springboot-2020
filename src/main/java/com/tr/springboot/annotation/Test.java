package com.tr.springboot.annotation;

/**
 * 使用自定义注解 @Annotations 的类
 *
 * @author TR
 * @version 1.0
 * @date 8/19/2020 2:47 PM
 */
public class Test {

    private DoSomeThing doSomeThing= new DoSomeThing();

    @Annotations
    public void test(){
        doSomeThing.test();
    }

}