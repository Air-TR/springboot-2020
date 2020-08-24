package com.tr.springboot.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 日志切面类
 *
 * @author TR
 * @version 1.0
 * @date 8/19/2020 9:53 AM
 */
@Aspect // @Aspect 表明是一个切面类
@Component
public class LogAspect {
    /**
     * @Pointcut 切入点，其中execution用于使用切面的连接点。
     * 使用方法：execution(方法修饰符(可选) 返回类型 方法名 参数 异常模式(可选))，可以使用通配符匹配字符，*可以匹配任意字符。
     */
    @Pointcut("execution(public * com.tr.springboot.aop.controller.*.*(..))") // 这边可以指定 controller/service 或者其他包
    public void logAspect(){}

    /** @Before 在方法前执行 */
    @Before("logAspect()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("doBefore");
    }

    /** @After 在方法后执行 */
    @After("logAspect()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("doAfter");
    }

    /** @AfterReturning 在方法执行完返回结果后执行 */
    @AfterReturning("logAspect()")
    public void doAfterReturning(JoinPoint joinPoint){
        System.out.println("doAfterReturning");
    }

    /** @AfterThrowing 在方法执行过程中抛出异常的时候执行 */
    @AfterThrowing("logAspect()")
    public void doAfterThrowing(JoinPoint joinPoint){
        System.out.println("doAfterThrowing");
    }

    /**
     * @Around 环绕通知，就是可以在执行前后都使用，这个方法参数必须为ProceedingJoinPoint，proceed()方法就是被切面的方法，
     * 上面四个方法可以使用JoinPoint，JoinPoint包含了类名，被切面的方法名，参数等信息。
     */
    @Around("logAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
//        System.out.println("doAround");
//        return joinPoint.proceed();
        System.out.println("doAround + 方法开始时间:" + System.currentTimeMillis());
        Object o = joinPoint.proceed();
        System.out.println("doAround + 方法结束时间:" + System.currentTimeMillis());
        return o;
    }



}
