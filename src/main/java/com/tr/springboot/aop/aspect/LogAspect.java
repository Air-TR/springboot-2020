package com.tr.springboot.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 日志切面类
 *
 * @Author TR
 * @version 1.0
 * @date 8/19/2020 9:53 AM
 */
@Aspect
@Component
public class LogAspect {

    /**
     * @Pointcut 标记的方法内不需要写代码，不执行，只是一个标记
     * 真正执行逻辑是在 @Before @After @AfterReturning @AfterThrowing @Around 这些注解标记的方法中
     * 也可以不使用 @Pointcut，直接将切入点表达式定义在 @Before @After ... 这些方法中，效果与定义 @Pointcut 一样
     */
    @Pointcut("execution(public * com.tr.springboot.aop.controller.*.*(..))" +
            "|| execution(public * com.tr.springboot.aop.service.*.*(..))")
    public void logAspect() {
    }

    /**
     * @Before 在方法前执行
     */
    @Before("logAspect()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("doBefore");
    }

    /**
     * @After 在方法后执行
     */
    @After("logAspect()")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("doAfter");
    }

    /**
     * @AfterReturning 在方法执行完返回结果后执行
     */
    @AfterReturning(value = "logAspect()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("doAfterReturning");
    }

    /**
     * @AfterThrowing 在方法执行过程中抛出异常的时候执行
     */
    @AfterThrowing(value = "logAspect()", throwing = "exception")
    public void doAfterThrowing(JoinPoint joinPoint, Exception exception) {
        System.out.println("doAfterThrowing");
    }

    /**
     * @Around 环绕通知，就是可以在执行前后都使用，这个方法参数必须为 ProceedingJoinPoint，proceed() 方法就是被切面的方法，
     * 上面四个方法可以使用 JoinPoint，JoinPoint 包含了类名，被切面的方法名，参数等信息。
     */
    @Around("logAspect()")
    public void doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("doAround + 方法开始时间:" + System.currentTimeMillis());
        joinPoint.proceed();
        System.out.println("doAround + 方法结束时间:" + System.currentTimeMillis());
    }

}