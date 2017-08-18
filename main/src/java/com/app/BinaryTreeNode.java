package com.app;

public class BinaryTreeNode {

    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int val) {
        super();
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        super();
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
