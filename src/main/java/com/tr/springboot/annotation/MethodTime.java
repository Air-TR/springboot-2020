package com.tr.springboot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解 @MethodTime（该注解功能在 MethodTimeAspect.java 中定义）
 *  本项目 @MethodTime 注解作用是：添加了 @MethodTime 的方法，会在方法执行前后，输出方法开始和结束时间。
 *
 * 可选注解：
 *  @Retention 注解的生命周期
 *  @Target 运用坐标
 *  @Documented 记录在java文档中
 *  @Order 优先级，有默认属性
 *
 * @author TR
 * @date 8/19/2020 10:50 AM
 */
/** 注解实现 AOP 的方式建议参考 --> com.tr.springboot.aop.annotation.ApiLog */
@Retention(RetentionPolicy.RUNTIME) // @Retention & @Target：https://blog.csdn.net/m0_37679452/article/details/81281310
@Target({ElementType.METHOD, ElementType.TYPE}) // 注解类型：METHOD - 加在方法上，TYPE - 加在类上
public @interface MethodTime { // 新建注解与新建接口类似，将 interface 改为 @interface 即可
    String value() default "";
}
