package com.tr.springboot;

import java.util.HashMap;
import java.util.Random;

/**
 * @Author: TR
 * @Date: 2023/6/13
 */
public class RandomMS {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(0, "Java JVM / JVM");
        map.put(1, "Java JVM / Java 基础");
        map.put(2, "Java JVM / Java 集合");
        map.put(3, "Spring / Spring");
        map.put(4, "多线程 高并发 / CDN（内容分发网络）");
        map.put(5, "多线程 高并发 / 读写分离 分库分表");
        map.put(6, "多线程 高并发 / 多线程");
        map.put(7, "多线程 高并发 / 消息队列");
        map.put(8, "分布式 / API 网关");
        map.put(9, "分布式 / Dubbo");
        map.put(10, "分布式 / RPC");
        map.put(11, "分布式 / 分布式 ID");
        map.put(12, "分布式 / 分布式理论");
        map.put(13, "分布式 / 分布式锁");
        map.put(14, "设计模式 / 设计模式");
        map.put(15, "数据库 / Hibernate、MyBatis");
        map.put(16, "数据库 / MySQL");
        map.put(17, "数据库 / Redis");
        map.put(18, "数据库 / 索引");
        map.put(19, "算法 数据结构 / 数据结构");
        map.put(20, "算法 数据结构 / 算法");
        map.put(21, "网络 / 网络");
        map.put(22, "问题 / Netty");
        map.put(23, "问题 / 操作系统");
        map.put(24, "问题 / 场景设计");
        map.put(25, "问题 / 权限认证");

        Random random = new Random();
        int num = random.nextInt(map.size());
        System.out.println(num + "：" + map.get(num));
    }

}
