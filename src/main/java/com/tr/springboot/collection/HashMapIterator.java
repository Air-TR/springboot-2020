package com.tr.springboot.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 测试 HashMap 遍历效率
 * 1.使用 EntrySet 遍历
 * 2.使用 KeySet 遍历
 *
 * @author TR
 * @version 1.0
 * @date 9/7/2020 2:57 PM
 */
public class HashMapIterator {

    /**
     * 数据量大的情况下发现使用 EntrySet 遍历效率高
     */
    public static void main(String[] args) {
        testHashMapIteratorByEntrySet();
        System.out.println("-------------------");
        testHashMapIteratorByKeySet();
    }

    public static void testHashMapIteratorByEntrySet() {
        Map map = createMap();
        long startTime  = System.currentTimeMillis();
        System.out.println("Start: " + startTime);
        hashMapIteratorByEntrySet(map);
        long endTime  = System.currentTimeMillis();
        System.out.println("End: " + endTime);
        System.out.println("Time: " + (endTime - startTime) + "ms");
    }

    public static void testHashMapIteratorByKeySet() {
        Map map = createMap();
        long startTime  = System.currentTimeMillis();
        System.out.println("Start: " + startTime);
        hashMapIteratorByKeySet(map);
        long endTime  = System.currentTimeMillis();
        System.out.println("End: " + endTime);
        System.out.println("Time: " + (endTime - startTime) + "ms");
    }

    public static void hashMapIteratorByEntrySet(Map map) {
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
//            System.out.println(key + " : " + value);
        }
    }

    public static void hashMapIteratorByKeySet(Map map) {
        Iterator iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            Object key = iterator.next();
            Object value = map.get(key);
//            System.out.println(key + " -> " + value);
        }
    }

    public static Map createMap() {
        Map map = new HashMap();
        for (int i = 1; i <= 1000000; i++) {
            map.put(i, i+1);
        }
        return map;
    }

}
