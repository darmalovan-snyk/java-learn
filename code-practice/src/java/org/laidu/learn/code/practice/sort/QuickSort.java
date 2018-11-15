package org.laidu.learn.code.practice.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 快排练习
 *
 * @author tiancai.zang
 * on 2018-11-13 18:10.
 */
@Slf4j
public class QuickSort {

    public static void main(String[] args) {

        int[] input = {1, 5, 4, 7, 10, 123, 3, 2, 6};

        quickSort(input);

        System.out.println(Arrays.stream(input).boxed().map(i -> i + "").collect(Collectors.joining(",")));

    }

    public static void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
    }

    private static void qsort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);

            qsort(arr, low, pivot - 1);

            qsort(arr, pivot + 1, high);
        }
    }

    /**
     * 保证 数组中在pivot(枢纽元)之前的元素均小于index上的元素, 之后的元素均大于枢纽元
     * @param arr
     * @param low
     * @param high
     * @return 枢纽元(pivot) 下标
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                --high;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                ++low;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }


}