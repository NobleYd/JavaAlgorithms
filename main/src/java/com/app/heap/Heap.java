package com.app.heap;

import java.util.ArrayList;
import java.util.List;

/***
 * Index: zero based.<vr/>
 * 
 * parent: (i - 1) / 2
 * 
 * left child: 2 * i + 1
 * 
 * right child: 2 * i + 2
 */
public class Heap {

    private List<Integer> data = new ArrayList<Integer>();

    /** 默认小顶堆 */
    private boolean isMinimalHeap = true;

    public boolean minimalOrder(int x, int y) {
        return x < y;
    }

    public boolean maximalOrder(int x, int y) {
        return x > y;
    }

    private boolean compare(int x, int y) {
        return isMinimalHeap ? minimalOrder(x, y) : maximalOrder(x, y);
    }

    /***
     * Constructor empty heap.
     * 
     * @param isMinimalHeap
     *            注意，如果使用目的是原地排序。则升序则使用大顶堆。降序使用小顶堆。
     */
    public Heap(boolean isMinimalHeap) {
        super();
        this.isMinimalHeap = isMinimalHeap;
    }

    /***
     * Constructors with initial data.
     * 
     * @param datas
     *            初始数据
     * @param isMinimalHeap
     *            注意，如果使用目的是原地排序。则升序则使用大顶堆。降序使用小顶堆。
     */
    public Heap(List<Integer> datas, boolean isMinimalHeap) {
        super();
        this.data = datas;
        this.isMinimalHeap = isMinimalHeap;
        this.makeHeap();
    }

    /** 获取指定索引的父结点索引 */
    private int parent(int current) {
        return (current - 1) / 2;
    }

    /** 获取指定索引的左孩子结点索引 */
    private int leftChild(int current) {
        return 2 * current + 1;
    }

    /** 获取指定索引的右孩子结点索引 */
    private int rightChild(int current) {
        return 2 * current + 2;
    }

    public int size() {
        return this.data.size();
    }

    /**
     * heapifyUp
     * 
     * @param pos
     *            start position
     */
    public void heapifyUp(int pos) {
        int target = data.get(pos);
        int parentPos = parent(pos);
        while (pos != 0) {
            if (compare(target, data.get(parentPos))) {
                data.set(pos, data.get(parentPos));
                pos = parentPos;
                parentPos = parent(pos);
            } else {
                break;
            }
        }
        data.set(pos, target);
    }

    /**
     * heapifyDown
     * 
     * @param pos
     *            start position
     * @param last
     *            end position
     */
    public void heapifyDown(int pos, int last) {
        int target = data.get(pos);
        int childPos = leftChild(pos);
        while (childPos <= last) {
            if (childPos + 1 <= last && compare(data.get(childPos + 1), data.get(childPos))) {
                childPos = childPos + 1;
            }
            if (compare(data.get(childPos), target)) {
                data.set(pos, data.get(childPos));
                pos = childPos;
                childPos = leftChild(pos);
            } else {
                break;
            }
        }
        data.set(pos, target);
    }

    // operations for heap's push and pop...
    public void push(int val) {
        this.data.add(val);
        this.heapifyUp(this.size() - 1);
    }

    public int pop() {
        int popVal = this.data.get(0);
        this.data.set(0, this.data.get(this.size() - 1));
        this.data.remove(this.size() - 1);
        this.heapifyDown(0, this.size() - 1);
        return popVal;
    }

    public void makeHeap() {
        int lastPos = this.size() - 1;
        int heapPos = parent(lastPos);
        while (heapPos >= 0) {
            this.heapifyDown(heapPos, lastPos);
            heapPos--;
        }
    }

    /***
     * Sort the data and reverse the heap order.<br/>
     * If it is minimal heap, the order is descending order, and then become a maximal heap.<br/>
     * If it is maximal heap, the order is ascending order, and then become a minimal heap.<br/>
     */
    public void heapSort() {
        // Sort
        int last = this.size() - 1;
        do {
            int tmp = data.get(0);
            data.set(0, data.get(last));
            data.set(last, tmp);
            this.heapifyDown(0, --last);
        } while (last > 0);
        // After sort, reset the heap type.
        this.isMinimalHeap = !this.isMinimalHeap;
    }

    @Override
    public String toString() {
        return "Heap [type=" + (isMinimalHeap ? "小顶堆" : "大顶堆") + ", data=" + data + "]";
    }

}
