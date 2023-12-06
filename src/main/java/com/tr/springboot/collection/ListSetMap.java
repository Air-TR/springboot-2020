package com.tr.springboot.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 研究 List Set Map 及其子类
 *
 * @Author TR
 * @version 1.0
 * @date 2020/9/7 下午10:31
 */
public class ListSetMap {

    public static void main(String[] args) {
        /**
         * 都在 java.util 包下: List Set 继承自 Collection, Map 没有继承, List Set Map 都是接口 interface
         * List ArrayList LinkedList
         * Set HashSet LinkedHashSet
         * Map HashMap Hashtable LinkedHashMap ConcurrentHashMap
         */
        List arrayList = new ArrayList();   // 继承自 AbstractList 实现 List,RandomAccess,Cloneable
        List linkedList = new LinkedList(); // 继承自 AbstractSequentialList 实现 List,Deque,Cloneable

        Set hashSet = new HashSet();                // 继承自 AbstractSet  实现 Set,Cloneable
        Set linkedHashSet = new LinkedHashSet();    // 继承自 HashSet      实现 Set,Cloneable

        Map hashMap = new HashMap<>();                      // 继承自 AbstractMap  实现 Map
        Map linkedHashMap = new LinkedHashMap<>();          // 继承自 HashMap      实现 Map
        Map hashTable = new Hashtable<>();                  // 继承自 Dictionary   实现 Map
        Map concurrentHashMap = new ConcurrentHashMap<>();  // 继承自 AbstractMap  实现 ConcurrentMap


        /**
         * List常用方法: https://www.cnblogs.com/xiaostudy/p/9503199.html (下面不懂的点这个链接)
         * void add(int index, E element)   在指定位置插入元素，后面的元素都往后移一个元素。
         * boolean addAll(int index, Collection<? extends E> c) 在指定的位置中插入c集合全部的元素，如果集合发生改变，则返回true，否则返回false。
         * E get(int index)         返回list集合中指定索引位置的元素
         * int indexOf(Object o)    返回list集合中第一次出现o对象的索引位置，如果list集合中没有o对象，那么就返回-1
         * ListIterator<E> listIterator()   返回此列表元素的列表迭代器（按适当顺序）。
         * ListIterator<E> listIterator(int index)  从指定位置开始，返回此列表元素的列表迭代器（按适当顺序）。
         * E remove(int index)      删除指定索引的对象
         * E set(int index, E element)      在索引为index位置的元素更改为element元素
         * List<E> subList(int fromIndex, int toIndex)  返回从索引fromIndex到toIndex的元素集合，包左不包右
         */
        arrayList.add(0);
        arrayList.remove(1);
        arrayList.get(1);
        linkedList.add(0);
        linkedList.remove(1);
        linkedList.get(1);

        /**
         * Set 常用方法: https://www.cnblogs.com/xiaostudy/p/9510311.html
         * 1. size()                获取Set尺寸（即Set包含数据元素的总数）。
         * 2. add(Object obj)       向Set中添加数据元素obj。 
         * 3. remove(Object obj)    从Set中移除数据元素obj。
         * 4. contains(Object obj)  判断当前Set中是否包含数据元素obj，如果包含返回true，否则返回false。
         * 5. iterator()            将Set装入迭代器。
         */
        hashSet.add(0);
        hashSet.remove(1);
        linkedHashSet.add(0);
        linkedHashSet.remove(1);

        /**
         * Map常用方法: https://www.cnblogs.com/xiaostudy/p/9510763.html (下面不懂的点此链接)
         * V put(K key, V value)    向map集合中添加Key为key，Value为value的元素，当添加成功时返回null，否则返回value
         * void putAll(Map m)       向map集合中添加指定集合的所有元素
         * V get(Object key)        根据map集合中元素的Key来获取相应元素的Value
         * V remove(Object key)     删除Key为key值的元素
         * void clear()             把map集合中所有的键值删除
         * int size()               返回map集合中元素个数
         * boolean isEmpty()        检出map集合中是否有元素，如果没有则返回true，如果有元素则返回false
         * boolean containsKey(Object key)      检出map集合中有没有包含Key为key的元素，如果有则返回true，否则返回false。
         * boolean containsValue(Object value)  检出map集合中有没有包含Value为value的元素，如果有则返回true，否则返回false。
         * boolean equals(Object o) 判断两个Set集合的元素是否相同
         * int hashCode()           返回map集合的哈希码值
         * Set keySet()             返回map集合中所有Key
         * Set<Entry> entrySet()    返回map到一个Set集合中，以map集合中的Key=Value的形式返回到set中。
         * Collection<V> values()   返回map集合中所有的Value到一个Collection集合
         */
        hashMap.put(1,1);
        hashMap.remove(1);
        hashMap.get(1);
        linkedHashMap.put(1,1);
        linkedHashMap.remove(1);
        linkedHashMap.get(1);
        hashTable.put(1,1);
        hashTable.remove(1);
        hashTable.get(1);
        concurrentHashMap.put(1,1);
        concurrentHashMap.remove(1);
        concurrentHashMap.get(1);
    }

}
