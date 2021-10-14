package com.tr.springboot.aop.testaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author rtao
 * @date 2021/10/14 10:34
 */
@Aspect
@Component
public class TestAOP {

    /**
     * @Pointcut 标记的方法内不需要写代码，不执行，只是一个标记
     *   真正执行逻辑是在 @Before @After @AfterReturning @AfterThrowing @Around 这些注解标记的方法中
     *   也可以不使用 @Pointcut，直接将切入点表达式定义在 @Before @After ... 这些方法中，效果与定义 @Pointcut 一样
     */
    @Pointcut("execution(* com.tr.springboot.aop.service.AopService.testAop*(..))")
    public void cutTestAop() {
    }

    /** @Before 在方法前执行 */
    @Before("cutTestAop()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("@Before run");
    }

    /** @After 在方法后执行 */
    @After("cutTestAop()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("@After run");
    }

    /** @AfterReturning 在方法执行完返回结果后执行 */
    @AfterReturning("cutTestAop()")
    public void doAfterReturning(JoinPoint joinPoint){
        System.out.println("@AfterReturning run");
    }

    /** @AfterThrowing 在方法执行过程中抛出异常的时候执行 */
    @AfterThrowing("cutTestAop()")
    public void doAfterThrowing(JoinPoint joinPoint){
        System.out.println("@AfterThrowing run");
    }

    /**
     * @Around 环绕通知，就是可以在执行前后都使用，这个方法参数必须为ProceedingJoinPoint，proceed()方法就是被切面的方法，
     * 上面四个方法可以使用JoinPoint，JoinPoint包含了类名，被切面的方法名，参数等信息。
     */
    @Around("cutTestAop()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("@Around start: " + System.currentTimeMillis());
        Object object = joinPoint.proceed();
        System.out.println("@Around end: " + System.currentTimeMillis());
        return object;
    }

}