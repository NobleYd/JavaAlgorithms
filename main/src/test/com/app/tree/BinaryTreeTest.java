package com.app.tree;

import org.junit.Test;

import com.app.BinaryTreeNode;
import com.app.TestBase;
import com.app.tree.binary.BinaryTree;

public class BinaryTreeTest extends TestBase {

    // 1
    // 1 2 3 4 5 6 7
    public BinaryTreeNode constructTestTree1() {

        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);

        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);

        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        return node1;
    }

    // 2
    // 1 2 3 4 5 7 10 14 15
    public BinaryTreeNode constructTestTree2() {
        BinaryTreeNode node14 = new BinaryTreeNode(14);
        BinaryTreeNode node15 = new BinaryTreeNode(15);
        BinaryTreeNode node7 = new BinaryTreeNode(7, node14, node15);

        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node5 = new BinaryTreeNode(5, node10, null);

        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);

        BinaryTreeNode node3 = new BinaryTreeNode(3, null, node7);

        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        return node1;
    }

    @Test
    public void test1() {
        BinaryTreeNode tree = constructTestTree1();

        BinaryTree.preOrderTraverse(tree);
        System.out.println();
        BinaryTree.inOrderTraverse(tree);
        System.out.println();
        BinaryTree.postOrderTraverse(tree);
        System.out.println();
        BinaryTree.levelOrderTraverse(tree);
        System.out.println();
        BinaryTree.nonRecursivePreOrderTraverse(tree);
        System.out.println();
        BinaryTree.nonRecursiveInOrderTraverse(tree);
        System.out.println();
        BinaryTree.nonRecursivePostOrderTraverse(tree);
        System.out.println();
    }

    @Test
    public void test2() {
        BinaryTreeNode tree = constructTestTree2();

        BinaryTree.preOrderTraverse(tree);
        System.out.println();
        BinaryTree.inOrderTraverse(tree);
        System.out.println();
        BinaryTree.postOrderTraverse(tree);
        System.out.println();
        BinaryTree.levelOrderTraverse(tree);
        System.out.println();
        BinaryTree.nonRecursivePreOrderTraverse(tree);
        System.out.println();
        BinaryTree.nonRecursiveInOrderTraverse(tree);
        System.out.println();
        BinaryTree.nonRecursivePostOrderTraverse(tree);
        System.out.println();
    }

}
