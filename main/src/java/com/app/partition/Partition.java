package com.app.partition;

import java.util.Random;

/***
 * 划分算法
 */
public class Partition {

    /***
     * 划分(升序)
     * 
     * @param datas
     *            数据
     * @param start
     *            开始位置（包含）
     * @param end
     *            结束位置（包含）
     * @return 返回划分标准的索引
     */
    public static int partition(int[] datas, int start, int end) {
        if (datas == null || start < 0 || start >= datas.length || end < 0 || end >= datas.length || start > end) {
            System.out.println("Partition.partition() 异常情况");
            return -1;
        }
        int pivotIndex = randomIndex(start, end);
        swap(datas, pivotIndex, end);

        pivotIndex = start;
        for (int i = start; i < end; i++) {
            if (datas[i] < datas[end]) {
                swap(datas, pivotIndex++, i);
            }
        }
        swap(datas, pivotIndex, end);
        return pivotIndex;
    }

    public static int partition2(int[] datas, int start, int end) {
        if (datas == null || start < 0 || start >= datas.length || end < 0 || end >= datas.length || start > end) {
            System.out.println("Partition.partition() 异常情况");
            return -1;
        }
        int pivotIndex = randomIndex(start, end);
        int pivotValue = datas[pivotIndex];
        swap(datas, pivotIndex, start);

        while (start < end) {
            while (start < end && pivotValue <= datas[end])
                end--;
            datas[start] = datas[end];
            while (start < end && datas[start] <= pivotValue)
                start++;
            datas[end] = datas[start];
        }
        datas[start] = pivotValue;
        return start;
    }

    /***
     * 交换
     * 
     * @param datas
     *            数据
     * @param i
     *            待交换索引1
     * @param j
     *            待交换索引2
     */
    private static void swap(int[] datas, int i, int j) {
        int tmp = datas[i];
        datas[i] = datas[j];
        datas[j] = tmp;
    }

    /***
     * 获取指定范围内一个随机整数
     * 
     * @param start
     *            开始值（包含）
     * @param end
     *            结束值（包含）
     * @return 随机数
     */
    // [0, end-start+1)
    // <==>
    // [0, end-start]
    // -->
    // [start, end]
    private static int randomIndex(int start, int end) {
        return start + new Random().nextInt(end - start + 1);
    }

}
