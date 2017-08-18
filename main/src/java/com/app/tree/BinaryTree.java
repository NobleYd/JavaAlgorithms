package com.app.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.app.BinaryTreeNode;

public class BinaryTree {

    private static void print(BinaryTreeNode node) {
        System.out.print(node.val + ", ");
    }

    // 前序
    public static void preOrderTraverse(BinaryTreeNode root) {
        if (root == null)
            return;
        print(root);
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    // 中序
    public static void inOrderTraverse(BinaryTreeNode root) {
        if (root == null)
            return;
        inOrderTraverse(root.left);
        print(root);
        inOrderTraverse(root.right);
    }

    // 后序
    public static void postOrderTraverse(BinaryTreeNode root) {
        if (root == null)
            return;
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        print(root);
    }

    // 层次遍历
    public static void levelOrderTraverse(BinaryTreeNode root) {
        if (root == null)
            return;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.remove();
            print(node);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    // 前序
    public static void nonRecursivePreOrderTraverse(BinaryTreeNode root) {
        if (root == null)
            return;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                print(root);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop().right;
            }
        }
    }

    // 中序
    public static void nonRecursiveInOrderTraverse(BinaryTreeNode root) {
        if (root == null)
            return;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                print(root);
                root = root.right;
            }
        }
    }

    // 后序
    public static void nonRecursivePostOrderTraverse(BinaryTreeNode root) {
        if (root == null)
            return;
        BinaryTreeNode pre = null;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.peek();
            if ((root.left == null && root.right == null) || (pre != null && (pre == root.left || pre == root.right))) {
                print(root);
                pre = root;
                stack.pop();
            } else {
                if (root.right != null)
                    stack.push(root.right);
                if (root.left != null)
                    stack.push(root.left);
            }
        }
    }

}
