package com.tr.springboot.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 新建自定义注解
 * 新建注解与新建接口类似，将interface改为@interface即可
 * 项目其他地方可以用 @MethodTime 使用该自定义注解
 *
 * @author TR
 * @date 8/19/2020 10:46 AM
 */

/**
 * @Target @Retention：https://blog.csdn.net/m0_37679452/article/details/81281310
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface MethodTime {
    String param() default "";
}
