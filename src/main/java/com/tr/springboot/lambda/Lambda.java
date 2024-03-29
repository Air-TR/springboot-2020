package com.tr.springboot.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Lambda 测试，代码来源：https://www.cnblogs.com/haixiang/p/11029639.html#1462250077
 * Lambda:
 *  集合过滤
 *  集合去重
 *  删除集合中某个元素
 *  集合遍历
 *  集合内元素排序
 *  创建线程
 *
 * @Author: rtao
 * @Date: 2020/10/30 15:21
 */
public class Lambda {

    public static void main(String[] args) {
        /** 集合过滤 */
        filter();

        /** 集合去重 */
        distinct();

        /** 删除集合中某个元素 */
        deleteElementInList();

        /** 集合遍历 */
        iteratorList();

        /** 集合内元素排序 */
        sortList();

        /** 创建线程 */
        createThread();
    }

    /**
     * lambda 过滤
     */
    private static void filter() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 3);
        List<Integer> filterList = list.stream().filter(a -> a == 3).collect(Collectors.toList());
        System.out.println(filterList);
    }

    /**
     * lambda 去重
     */
    private static void distinct() {
        List<Integer> list = Arrays.asList(8, 3, 8, 3, 6, 5, 9, 5, 6, 7);
        List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctList);
    }

    /**
     * lambda 删除集合中某个元素
     */
    private static void deleteElementInList() {
        List<Object> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, "A", "B", "C");
        list.removeIf(ele -> ele.equals("B")); // 删除值为"B"的元素
        list.removeIf(ele -> ele.equals(list.get(2))); // 删除下标为2的元素
        list.forEach(System.out::println);
    }

    /**
     * lambda 集合遍历
     */
    private static void iteratorList() {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5);
        list.forEach(element -> {
            if (element % 2 == 0) {
                System.out.println(element);
            }
        });
    }

    /**
     * lambda 集合内元素排序
     */
    private static void sortList() {
        ArrayList<Item> list = new ArrayList<>();
        list.add(new Item(11, "半袖", 37.45));
        list.add(new Item(14, "风衣", 139.80));
        list.add(new Item(13, "背心", 7.80));
        list.add(new Item(12, "秋裤", 55.33));
        /*
        list.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        });
        */
        list.sort(Comparator.comparing(Item::getPrice));
//        list.sort((o1, o2) -> o1.getPrice().compareTo(o2.getPrice())); // 与上行代码效果相同
        list.forEach(System.out::println);
    }

    /**
     * lambda 创建线程
     */
    private static void createThread() {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(2 + ":" + i);
            }
        });
        t.start();
    }

    private static class Item {
        private Integer id;
        private String name;
        private Double price;

        public Item(Integer id, String name, Double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public Double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Item{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
        }
    }

}
