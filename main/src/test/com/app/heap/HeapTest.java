package com.app.heap;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.app.heap.Heap;
import com.app.TestBase;

public class HeapTest extends TestBase {

    @Test
    public void test1() {
        Heap heap = new Heap(true);
        heap.push(9);
        heap.push(12);
        heap.push(17);
        heap.push(30);
        heap.push(50);
        heap.push(20);
        heap.push(60);
        heap.push(65);
        heap.push(4);
        heap.push(19);

        System.out.println(heap);
        heap.heapSort();
        System.out.println(heap);
    }

    @Test
    public void test2() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(9);
        list.add(12);
        list.add(17);
        list.add(30);
        list.add(50);
        list.add(20);
        list.add(60);
        list.add(65);
        list.add(4);
        list.add(19);
        Heap heap = new Heap(list, true);

        System.out.println(heap);
        heap.heapSort();
        System.out.println(heap);
    }

}
