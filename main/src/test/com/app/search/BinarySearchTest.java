package com.app.search;

import org.junit.Test;

import com.app.search.BinarySearch;
import com.app.sort.QuickSort;
import com.app.TestBase;

public class BinarySearchTest extends TestBase {

    @Test
    public void test1() {
        int[] datas = new int[] { 13, 14, 21, 520, 125, 521, 1314 };
        super.print(datas);
        QuickSort.quickSort(datas, 0, datas.length - 1);
        super.print(datas);
        int index = BinarySearch.search(datas, 0, datas.length - 1, 520);
        System.out.println(index);
    }

}
