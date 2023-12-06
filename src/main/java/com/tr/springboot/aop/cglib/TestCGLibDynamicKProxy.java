package com.tr.springboot.aop.cglib;

/**
 * cglib 动态代理测试类
 *
 * @Author TR
 * @version 1.0
 * @date 9/3/2020 10:01 AM
 */
public class TestCGLibDynamicKProxy {

    public static void main(String[] args) {
        CGLIBProxy CGLIBproxy = new CGLIBProxy();
        CGLIBService testCGLIBProxy = (CGLIBService) CGLIBproxy.createProxyInstance(new CGLIBService()); // 传入要代理的真实对象
        testCGLIBProxy.add();
    }

}
