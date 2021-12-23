package com.tr.springboot.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 排序：以下 map 先按 height 排序，再按 age 排序
 *
 * @author rtao
 * @date 2021/3/3 15:56
 */
public class ListMapSort {

    public static void main(String[] args) {

        List<Map<String, Object>> list = new ArrayList<>();

        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("name","laowang");
        map1.put("age",25);
        map1.put("height",175);

        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("name","wangliu");
        map2.put("age",23);
        map2.put("height",165);

        HashMap<String, Object> map3 = new HashMap<>();
        map3.put("name","laoliu1");
        map3.put("age",26);
        map3.put("height",180);

        HashMap<String, Object> map4 = new HashMap<>();
        map4.put("name","laoliu2");
        map4.put("age",24);
        map4.put("height",185);

        HashMap<String, Object> map5 = new HashMap<>();
        map5.put("name","laoliu3");
        map5.put("age",24);
        map5.put("height",176);

        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);

        // 排序前
        System.out.println("排序前:");
        for (Map<String, Object> map : list) {
            System.out.println(map.toString());
        }

        Collections.sort(list, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Integer height1 = (Integer) o1.get("height");
                Integer height2 = (Integer) o2.get("height");
                return height1.compareTo(height2); //升序
            }
        });

        // 排序后
        System.out.println("排序后-1:");
        for (Map<String, Object> map : list) {
            System.out.println(map.toString());
        }

        Collections.sort(list, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Integer age1 = (Integer) o1.get("age");
                Integer age2 = (Integer) o2.get("age");
                return age1.compareTo(age2); //升序
            }
        });

        // 排序后
        System.out.println("排序后-2:");
        for (Map<String, Object> map : list) {
            System.out.println(map.toString());
        }
    }
}
