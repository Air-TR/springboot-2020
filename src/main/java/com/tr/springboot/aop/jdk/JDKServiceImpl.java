package com.tr.springboot.aop.jdk;

/**
 * @author TR
 * @version 1.0
 * @date 9/3/2020 9:41 AM
 */
public class JDKServiceImpl implements JDKService {

    @Override
    public int add() {
        System.out.println("开始执行 jdk service ...");
        return 0;
    }

}
