package com.tr.springboot.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Lambda 测试，代码来源：https://www.cnblogs.com/haixiang/p/11029639.html#1462250077
 * Lambda:
 *  删除集合中的某个元素
 *  遍历集合
 *  创建线程
 *  集合内元素排序
 *
 * @Author: rtao
 * @Date: 2020/10/30 15:21
 */
public class Lambda {

    public static void main(String[] args) {
        /** 删除集合中的某个元素 */
        deleteElementInList();
        /** 遍历集合 */
        iteratorList();
        /** 集合内元素排序 */
        sortList();
        /** 创建线程 */
        createThread();
    }

    /**
     * Lambda 删除集合中的某个元素
     */
    private static void deleteElementInList() {
        System.out.println(">>>> Lambda 删除集合中的某个元素 <<<<");
        List<Object> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, "A", "B", "C");
        list.removeIf(ele -> ele.equals("B")); // 删除值为"B"的元素
        list.removeIf(ele -> ele.equals(list.get(2))); // 删除下标为2的元素
        list.forEach(System.out::println);
    }

    /**
     * Lambda 遍历集合
     */
    private static void iteratorList() {
        System.out.println(">>>> Lambda 遍历集合 <<<<");
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5);
        list.forEach(element -> {
            if (element % 2 == 0) {
                System.out.println(element);
            }
        });
    }

    /**
     * Lambda 创建线程
     */
    private static void createThread() {
        System.out.println(">>>> Lambda 创建线程 <<<<");
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(2 + ":" + i);
            }
        });
        t.start();
    }

    /**
     * Lambda 集合内元素排序
     */
    private static void sortList() {
        System.out.println(">>>> Lambda 集合内元素排序 <<<<");
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
        list.sort((o1, o2) -> o1.getPrice().compareTo(o2.getPrice()));
        list.forEach(System.out::println);
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
