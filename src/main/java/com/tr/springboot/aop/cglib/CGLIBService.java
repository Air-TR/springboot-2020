package com.tr.springboot.aop.cglib;

/**
 * cglib 与 jdk 区别：直接定义的实现类，没有实现接口
 *
 * @author TR
 * @version 1.0
 * @date 9/3/2020 9:55 AM
 */
public class CGLIBService {

    public int add() {
        System.out.println("开始执行 cglib service ...");
        return 0;
    }

}
