package com.tr.springboot.aop.jdk;

/**
 * @author TR
 * @version 1.0
 * @date 9/3/2020 9:34 AM
 */
public interface JDKService {

    /**
     * https://www.cnblogs.com/Mike_Chang/p/6618117.html
     * 接口修饰符默认 public abstract，（private、protected 不能用，编译错误）
     */
    int add();

}
