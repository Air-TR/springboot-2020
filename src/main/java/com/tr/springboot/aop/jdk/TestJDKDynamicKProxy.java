package com.tr.springboot.aop.jdk;

/**
 * jdk 动态代理测试类
 *
 * @author TR
 * @version 1.0
 * @date 9/3/2020 9:47 AM
 */
public class TestJDKDynamicKProxy {

    public static void main(String[] args) {

        /**
         * 使用 JDK 动态代理
         */
        JDKDynamicProxy JDKDynamicProxyTarget = new JDKDynamicProxy();
        JDKService testServiceProxy = (JDKService) JDKDynamicProxyTarget.createProxyInstance(new JDKServiceImpl()); // 传入要代理的真实对象
        //执行代理类的方法
        testServiceProxy.add();

        /** 直接调用，不用代理 */
//        TestService testService = new TestServiceImpl();
//        testService.add();

    }

}
