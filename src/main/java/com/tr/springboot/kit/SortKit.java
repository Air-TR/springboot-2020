package com.tr.springboot.kit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: TR
 */
public class SortKit {

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(2.3);
        list.add(1.6);
        list.add(5.0);

        // 正序排序
        Collections.sort(list);
        // 倒序排序
        Collections.sort(list, Comparator.reverseOrder());

        System.out.println();
    }

}
