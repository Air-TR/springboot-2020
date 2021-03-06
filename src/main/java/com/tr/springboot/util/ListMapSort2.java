package com.tr.springboot.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author rtao
 * @date 2021/3/3 17:38
 */
public class ListMapSort2 {

    @Test
    public void test(){
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
        map3.put("age",24);
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

        //排序前
        System.out.println("排序前:");
        for (Map<String, Object> map : list) {
            System.out.println(map.toString());
        }

        List<Map<String, Object>> list1 = this.sortList(list);

        //排序后
        System.out.println("排序后:");
        for (Map<String, Object> map : list1) {
            System.out.println(map.toString());
        }
    }

    private List<Map<String, Object>> sortList(List<Map<String, Object>> list){
        return list.stream().sorted(Comparator.comparing(ListMapSort2::comparingByAge).reversed()
                .thenComparing(Comparator.comparing(ListMapSort2::comparingByName).reversed()))
                .collect(Collectors.toList());
    }

    private static Integer comparingByAge(Map<String, Object> map){
        return (Integer) map.get("age");
    }

    private static Integer comparingByName(Map<String, Object> map){
        return (Integer) map.get("height");
    }

}
