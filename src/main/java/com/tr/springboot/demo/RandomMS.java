package com.tr.springboot.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: TR
 * @Date: 2023/6/13
 */
public class RandomMS {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java JVM / JVM");
        list.add("Java JVM / Java 基础");
        list.add("Java JVM / Java 集合");
        list.add("Spring / Spring");
        list.add("Spring / Spring 循环依赖");
        list.add("多线程 高并发 / CDN（内容分发网络）");
        list.add("多线程 高并发 / 读写分离 分库分表");
        list.add("多线程 高并发 / 多线程");
        list.add("多线程 高并发 / 消息队列");
        list.add("分布式 / API 网关");
        list.add("分布式 / Dubbo");
        list.add("分布式 / RPC");
        list.add("分布式 / 分布式 ID");
        list.add("分布式 / 分布式理论");
        list.add("分布式 / 分布式锁");
        list.add("设计模式 / 设计模式");
        list.add("数据库 / Hibernate、MyBatis");
        list.add("数据库 / MySQL");
        list.add("数据库 / Redis");
        list.add("数据库 / 索引");
        list.add("算法 数据结构 / 数据结构");
        list.add("算法 数据结构 / 算法");
        list.add("网络 / 网络");
        list.add("问题 / Netty");
        list.add("问题 / 操作系统");
        list.add("问题 / 场景设计");
        list.add("问题 / 权限认证");

        Random random = new Random();
        int num = random.nextInt(list.size());
        System.out.println(num + "：" + list.get(num));
    }

}
