package com.tr.springboot.aop.service.impl;

import com.tr.springboot.annotation.MethodTime;
import com.tr.springboot.aop.service.AopService;
import org.springframework.stereotype.Service;

/**
 * @author TR
 * @version 1.0
 * @date 8/19/2020 10:09 AM
 */
@Service
public class AopServiceImpl implements AopService {

    @MethodTime
    @Override
    public String testAop() {
        System.out.println("AopServiceImpl: Test AOP Success");
//        int i = 1 / 0; // 制造异常，若AOP监控service包的话，打开此行会走 @AfterThrowing 修饰的方法，否则走 @AfterReturning 修饰方法。
        return "Test AOP Success";
    }

}
