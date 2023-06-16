package com.tr.springboot.algorithm;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: TR
 * @Date: 2023/6/13
 */
public class SortAlgorithm {

    public static void main(String[] args) {
        int[] arr = {14, 30, 45, 20, 23, 6, 13, 18, 10, 51, 8, 4, 19, 23, 15};
//        Arrays.sort(arr,Collections.reverseOrder());
//        bubbleSort(arr); // 冒泡排序

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     *  算法时间复杂度为 O(n^2)，不适用于大规模数据的排序
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
