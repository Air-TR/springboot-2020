package com.tr.springboot.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 创建自定义注解对应切面
 * 内容与 LogAspect.class 类似
 *
 * @Author TR
 * @version 1.0
 * @date 8/19/2020 10:49 AM
 */
@Aspect
@Component
public class MethodTimeAspect {

//    @Pointcut("execution(public * com.tr.springboot.aop.controller.*.*(..))") // 这边可以指定 controller、service 或其他包
//    public void logAspect() {}

    @Around("@annotation(methodTime)")
    public Object around(ProceedingJoinPoint joinPoint, MethodTime methodTime) throws Throwable { // 这里的 MethodTime 就是自定义的注解
        System.out.println("MethodTimeAspect + 方法开始时间:" + System.currentTimeMillis());
        Object o = joinPoint.proceed();
        System.out.println("MethodTimeAspect + 方法结束时间:" + System.currentTimeMillis());
        return o;
    }

}
