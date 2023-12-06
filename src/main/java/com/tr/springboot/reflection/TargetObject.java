package com.tr.springboot.reflection;

/**
 * @Author TR
 * @date 2022/7/29 下午5:25
 */
public class TargetObject {

    private String value;

    public TargetObject() {
        value = "JavaGuide";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }

}
