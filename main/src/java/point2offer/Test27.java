package point2offer;

/**
 * Author: 鐜嬩繆瓒�
 * Date: 2015-04-25
 * Time: 13:50
 * Declaration: All Rights Reserved !!!
 */
public class Test27 {
    /**
     * 浜屽弶鏍戠殑鏍戠粨鐐�
     */
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    /**
     * 棰樼洰锛氳緭鍏ヤ竴妫典簩鍙夋悳绱㈡爲锛屽皢璇ヤ簩鍙夋悳绱㈡爲杞崲鎴愪竴涓帓搴忕殑鍙屽悜閾捐〃銆�
     * 瑕佹眰涓嶈兘鍒涘缓浠讳綍鏂扮殑缁撶偣锛屽彧鑳借皟鏁存爲涓粨鐐规寚閽堢殑鎸囧悜銆�
     *
     * @param root 浜屽弶鏍戠殑鏍圭粨鐐�
     * @return 鍙屽悜閾捐〃鐨勫ご缁撶偣
     */
    public static BinaryTreeNode convert(BinaryTreeNode root) {

        // 鐢ㄤ簬淇濆瓨澶勭悊杩囩▼涓殑鍙屽悜閾捐〃鐨勫熬缁撶偣
        BinaryTreeNode[] lastNode = new BinaryTreeNode[1];
        convertNode(root, lastNode);

        // 鎵惧埌鍙屽悜閾捐〃鐨勫ご缁撶偣
        BinaryTreeNode head = lastNode[0];
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }


    /**
     * 閾捐〃琛ㄨ浆鎹㈡搷浣�
     *
     * @param node     褰撳墠鐨勬牴缁撶偣
     * @param lastNode 宸茬粡澶勭悊濂界殑鍙屽悜閾捐〃鐨勫熬缁撶偣锛屼娇鐢ㄤ竴涓暱搴︿负1鐨勬暟缁勶紝绫讳技C++涓殑浜岀骇鎸囬拡
     */
    public static void convertNode(BinaryTreeNode node, BinaryTreeNode[] lastNode) {
        // 缁撶偣涓嶄负绌�
        if (node != null) {

            // 濡傛灉鏈夊乏瀛愭爲灏卞厛澶勭悊宸﹀瓙鏍�
            if (node.left != null) {
                convertNode(node.left, lastNode);
            }

            // 灏嗗綋鍓嶇粨鐐圭殑鍓嶉┍鎸囧悜宸茬粡澶勭悊濂界殑鍙屽悜閾捐〃锛堢敱褰撳墠缁撶偣鐨勫乏瀛愭爲鏋勬垚锛夌殑灏剧粨鐐�
            node.left = lastNode[0];

            // 濡傛灉宸﹀瓙鏍戣浆鎹㈡垚鐨勫弻鍚戦摼琛ㄤ笉涓虹┖锛岃缃熬缁撶偣鐨勫悗缁�
            if (lastNode[0] != null) {
                lastNode[0].right = node;
            }

            // 璁板綍褰撳墠缁撶偣涓哄熬缁撶偣
            lastNode[0] = node;

            // 澶勭悊鍙冲瓙鏍�
            if (node.right != null) {
                convertNode(node.right, lastNode);
            }
        }
    }


    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
        test05();
    }

    private static void printList(BinaryTreeNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.right;
        }

        System.out.println("null");
    }

    private static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + "->");
            printTree(root.right);
        }
    }


    //            10
    //         /      \
    //        6        14
    //       /\        /\
    //      4  8     12  16
    private static void test01() {
        BinaryTreeNode node10 = new BinaryTreeNode();
        node10.value = 10;

        BinaryTreeNode node6 = new BinaryTreeNode();
        node6.value = 6;

        BinaryTreeNode node14 = new BinaryTreeNode();
        node14.value = 14;

        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.value = 4;

        BinaryTreeNode node8 = new BinaryTreeNode();
        node8.value = 8;

        BinaryTreeNode node12 = new BinaryTreeNode();
        node12.value = 12;

        BinaryTreeNode node16 = new BinaryTreeNode();
        node16.value = 16;

        node10.left = node6;
        node10.right = node14;

        node6.left = node4;
        node6.right = node8;

        node14.left = node12;
        node14.right = node16;

        System.out.print("Before convert: ");
        printTree(node10);
        System.out.println("null");
        BinaryTreeNode head = convert(node10);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();

    }

    //               5
    //              /
    //             4
    //            /
    //           3
    //          /
    //         2
    //        /
    //       1
    private static void test02() {
        BinaryTreeNode node1 = new BinaryTreeNode();
        node1.value = 1;

        BinaryTreeNode node2 = new BinaryTreeNode();
        node2.value = 2;

        BinaryTreeNode node3 = new BinaryTreeNode();
        node3.value = 3;

        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.value = 4;

        BinaryTreeNode node5 = new BinaryTreeNode();
        node5.value = 5;

        node5.left = node4;
        node4.left = node3;
        node3.left = node2;
        node2.left = node1;

        System.out.print("Before convert: ");
        printTree(node5);
        System.out.println("null");
        BinaryTreeNode head = convert(node5);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    private static void test03() {
        BinaryTreeNode node1 = new BinaryTreeNode();
        node1.value = 1;

        BinaryTreeNode node2 = new BinaryTreeNode();
        node2.value = 2;

        BinaryTreeNode node3 = new BinaryTreeNode();
        node3.value = 3;

        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.value = 4;

        BinaryTreeNode node5 = new BinaryTreeNode();
        node5.value = 5;

        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;

        System.out.print("Before convert: ");
        printTree(node1);
        System.out.println("null");
        BinaryTreeNode head = convert(node1);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    // 鍙湁涓�涓粨鐐�
    private static void test04() {
        BinaryTreeNode node1 = new BinaryTreeNode();
        node1.value = 1;

        System.out.print("Before convert: ");
        printTree(node1);
        System.out.println("null");
        BinaryTreeNode head = convert(node1);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    // 娌℃湁缁撶偣
    private static void test05() {
        System.out.print("Before convert: ");
        printTree(null);
        System.out.println("null");
        BinaryTreeNode head = convert(null);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }
}
