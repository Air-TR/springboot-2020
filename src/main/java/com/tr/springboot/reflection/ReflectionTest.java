package com.tr.springboot.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author TR
 * @date 2022/8/6 下午5:04
 */
public class ReflectionTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        /** 获取 TargetObject 类的 Class 对象并且创建 TargetObject 类实例 */
        Class<?> targetClass = Class.forName("com.tr.springboot.reflection.TargetObject");
        TargetObject targetObject = (TargetObject) targetClass.newInstance();

        /** 获取 TargetObject 类中定义的所有方法 */
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        /** 获取指定方法并调用 */
        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);

        publicMethod.invoke(targetObject, "JavaGuide");

        /** 获取指定参数并对参数进行修改 */
        Field field = targetClass.getDeclaredField("value");
        // 为了对类中的参数进行修改，取消安全检查
        field.setAccessible(true);
        field.set(targetObject, "Hello");

        /** 调用 private 方法 */
        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        // 为了调用 private 方法，取消安全检查
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);
    }

}
