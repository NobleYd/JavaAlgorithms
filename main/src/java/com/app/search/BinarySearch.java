package com.app.search;

public class BinarySearch {

    public static int search(int[] datas, int start, int end, int target) {
        if (datas == null || start < 0 || start >= datas.length || end < 0 || end >= datas.length || start > end) {
            System.out.println("Partition.partition() 异常情况");
            return -1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == datas[mid]) {
                return mid;
            } else if (target < datas[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}
