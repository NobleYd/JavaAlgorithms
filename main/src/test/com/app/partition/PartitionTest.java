package com.app.partition;

import org.junit.Test;

import com.app.partition.Partition;
import com.app.TestBase;

/***
 * 划分算法
 */
public class PartitionTest extends TestBase {

    @Test
    public void test1() {
        //int[] datas = new int[] { 1, 3, 1, 4, 2, 1, 1, 3, 1, 4, 2, 5, 4, 3, 6, 3, 1, 2, 3, 41, 234, 34, 12, 3, 34 };
        int[] datas = new int[]{5,2,1,3,4};
        super.print(datas);
        int index = Partition.partition(datas, 0, datas.length - 1);
        System.out.println(index);
        super.print(datas);
    }

}
