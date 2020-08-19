package com.tr.springboot.aop.aspect;

import com.tr.springboot.aop.annotation.MethodTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 * 创建自定义注解对应切面
 * 内容与 LogAspect类 切面类似
 *
 * @author TR
 * @version 1.0
 * @date 8/19/2020 10:49 AM
 */
@Aspect
@Component
public class MethodTimeAspect {

//    @Pointcut("execution(public * com.tr.springboot.aop.controller.*.*(..))") // 这边可以指定 controller/service 或者其他包
//    public void logAspect(){}

    @Around("@annotation(methodTime)")
    public Object around(ProceedingJoinPoint joinPoint, MethodTime methodTime) throws Throwable {
        System.out.println("方法开始时间是:" + System.currentTimeMillis());
        Object o = joinPoint.proceed();
        System.out.println("方法结束时间是:" + System.currentTimeMillis());
        return o;
    }

}
