package com.tr.springboot.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 循环删除 List
 *
 * @Author: TR
 * @Date: 2023/5/12
 */
public class RemoveFromList {

    private static List<String> list = new ArrayList<>();

    static {
        list.add("element1");
        list.add("element2");
        list.add("element3");
    }

    public static void main(String[] args) {
        // 使用 stream filter 过滤
        filterByStream();
        // 使用 Iterator 删除
        removeByIterator();
    }

    public static void filterByStream() {
        list = list.stream().filter(e -> !e.contains("2")).collect(Collectors.toList());
        System.out.println(list);
    }

    public static void removeByIterator() {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.contains("2")) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

}
