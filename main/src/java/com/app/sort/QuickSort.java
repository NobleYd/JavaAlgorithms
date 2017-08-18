package com.app.sort;

import com.app.partition.Partition;

public class QuickSort {

    public static void quickSort(int[] datas, int start, int end) {
        if (datas == null || start < 0 || start >= datas.length || end < 0 || end >= datas.length || start > end) {
            return;
        }
        int pivotIndex = Partition.partition(datas, start, end);
        quickSort(datas, start, pivotIndex - 1);
        quickSort(datas, pivotIndex + 1, end);
    }

}
