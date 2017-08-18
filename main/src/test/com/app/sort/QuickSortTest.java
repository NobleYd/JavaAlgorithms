package com.app.sort;

import org.junit.Test;

import com.app.partition.Partition;
import com.app.sort.QuickSort;
import com.app.TestBase;

public class QuickSortTest extends TestBase {

    @Test
    public void test1() {
        // int[] datas = new int[] { 1, 3, 1, 4, 2, 1, 1, 3, 1, 4, 2, 5, 4, 3, 6, 3, 1, 2, 3, 41, 234, 34, 12, 3, 34 };
        int[] datas = new int[] { 1, 2, 3, 2, 2, 1 };
        super.print(datas);
        QuickSort.quickSort(datas, 0, datas.length - 1);
        super.print(datas);
    }

}
