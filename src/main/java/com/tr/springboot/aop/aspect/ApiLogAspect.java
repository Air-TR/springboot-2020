package com.tr.springboot.aop.aspect;

import com.tr.springboot.aop.annotation.ApiLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author taorun
 * @date 2023/1/11 18:17
 */
@Aspect
@Component
public class ApiLogAspect {

    @AfterReturning(value = "@annotation(apiLog)", returning = "result")
    public void afterReturning(JoinPoint joinPoint, ApiLog apiLog, Object result) {
        /** 参数 */
        Object[] args = joinPoint.getArgs();
        /** 方法名称 */
        String methodName = joinPoint.getSignature().getName();
        /** 方法所在类 */
        Class classType = joinPoint.getSignature().getDeclaringType();
        /** 方法所在类路径（名称） */
        String classPath = joinPoint.getSignature().getDeclaringTypeName();
        System.out.println("afterReturning");
    }

    @AfterThrowing(value = "@annotation(apiLog)", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, ApiLog apiLog, Exception exception) {
        System.out.println("afterThrowing");
    }

}
