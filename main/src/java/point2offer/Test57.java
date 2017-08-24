package point2offer;

/**
 * Author: 鐜嬩繆瓒�
 * Date: 2015-06-16
 * Time: 09:18
 * Declaration: All Rights Reserved !!!
 */
public class Test57 {
    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    private static ListNode deleteDuplication(ListNode head) {
        // 涓簄ull
        if (head == null) {
            return null;
        }

//        // 鍙湁涓�涓粨鐐�
//        if (head.next == null) {
//            return head;
//        }

        // 涓存椂鐨勫ご缁撶偣
        ListNode root = new ListNode();
        root.next = head;
        // 璁板綍鍓嶉┍缁撶偣
        ListNode prev = root;
        // 璁板綍褰撳墠澶勭悊鐨勭粨鐐�
        ListNode node = head;
        while (node != null && node.next != null) {
            // 鏈夐噸澶嶇粨鐐癸紝涓巒ode鍊肩浉鍚岀殑缁撶偣閮借鍒犻櫎
            if (node.val == node.next.val) {
                // 鎵惧埌涓嬩竴涓笉鍚屽�肩殑鑺傜偣锛屾敞鎰忓叾鏈夊彲鑳戒篃鏄噸澶嶈妭鐐�
                while (node.next != null && node.next.val == node.val) {
                    node = node.next;
                }
                // 鎸囧悜涓嬩竴涓妭鐐癸紝prev.next涔熷彲鑳芥槸閲嶅缁撶偣
                // 鎵�浠rev涓嶈绉诲姩鍒颁笅涓�涓粨鐐�
                prev.next = node.next;
            }
            // 鐩搁偦涓や釜鍊间笉鍚岋紝璇存槑node涓嶅彲鍒犻櫎锛岃淇濈暀
            else {
                prev.next = node;
                prev = prev.next;

            }
            node = node.next;
        }

        return root.next;

    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
        test05();
        test06();
        test07();
        test08();
        test09();
        test10();
    }

    // 1->2->3->3->4->4->5
    private static void test01() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplication(n1);
        print(result);
    }

    // 1->2->3->4->5->6->7
    private static void test02() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplication(n1);
        print(result);
    }

    // 1->1->1->1->1->1->2
    private static void test03() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(2);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplication(n1);
        print(result);
    }


    // 1->1->1->1->1->1->1
    private static void test04() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplication(n1);
        print(result);
    }

    // 1->1->2->2->3->3->4->4
    private static void test05() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(4);
        ListNode n8 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        ListNode result = deleteDuplication(n1);
        print(result);
    }

    // 1->1->2->3->3->4->5->5
    private static void test06() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        ListNode n8 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        ListNode result = deleteDuplication(n1);
        print(result);
    }

    // 1->1->2->2->3->3->4->5->5
    private static void test07() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(4);
        ListNode n8 = new ListNode(5);
        ListNode n9 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;

        ListNode result = deleteDuplication(n1);
        print(result);
    }

    // 1->2
    private static void test08() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);

        n1.next = n2;

        ListNode result = deleteDuplication(n1);
        print(result);
    }

    // 1
    private static void test09() {
        ListNode n1 = new ListNode(1);
        ListNode result = deleteDuplication(n1);
        print(result);
    }

    // null
    private static void test10() {
        ListNode result = deleteDuplication(null);
        print(result);
    }
}
