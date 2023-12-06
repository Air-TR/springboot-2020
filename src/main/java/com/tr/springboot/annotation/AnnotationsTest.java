package com.tr.springboot.annotation;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 利用反射，使注解可以使用
 *
 * @Author TR
 * @version 1.0
 * @date 8/19/2020 2:48 PM
 */
// 反射注解
public class AnnotationsTest {

    public static void main(String[] args) throws Exception {
        System.out.println("执行自定义注解开始时间：" + new Date());
        Class clazz = AnnotationsUse.class;
        Method[] ms = clazz.getMethods();
        for (Method method : ms) {
            boolean flag = method.isAnnotationPresent(Annotations.class);
            if (flag) {
                method.invoke(clazz.newInstance(), null);
            }
        }
    }

}