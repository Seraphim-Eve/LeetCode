package com.leetcode;

/**
 * 2. Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 */
public class SolutionQ2 {

    public static class ListNode {
        private final int val;

        private ListNode next;

        public ListNode(int data) {
            val = data;
        }

        public ListNode(int data, ListNode next) {
            val = data;
            this.next = next;
        }
    }

    /**
     * length of node
     * @param node node
     * @return node
     */
    public static int len(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean flag = len(l1) >= len(l2);
        //最长list node
        ListNode longListNode;
        //最短list node
        ListNode shortListNode;
        if (flag) {
            longListNode = l1;
            shortListNode = l2;
        } else {
            longListNode = l2;
            shortListNode = l1;
        }

        ListNode tmp = null;

        //记录每次最后一个节点
        ListNode cur = null;

        //进位
        int carry = 0;
        while (longListNode != null) {
            int sum;
            if (shortListNode != null) {
                sum = longListNode.val + shortListNode.val + carry;
                shortListNode = shortListNode.next;
            } else {
                sum = longListNode.val + carry;
            }

            carry = sum / 10;

            sum = sum % 10;

            if (tmp == null) {
                tmp = new ListNode(sum);
                cur = tmp;
            } else {
                cur.next = new ListNode(sum);
                cur = cur.next;
            }
            longListNode = longListNode.next;
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
        }

        return tmp;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;

        ListNode t1 = new ListNode(5);
        ListNode t2 = new ListNode(6);
        ListNode t3 = new ListNode(4);
        t1.next = t2;
        t2.next = t3;

        int len = len(n1);
        System.out.println(len);

        len = len(t1);
        System.out.println(len);

        ListNode listNode = addTwoNumbers(n1, t1);
        print(listNode);*/

        /*ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(9);
        ListNode n7 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode t1 = new ListNode(9);
        ListNode t2 = new ListNode(9);
        ListNode t3 = new ListNode(9);
        ListNode t4 = new ListNode(9);
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;

        int len = len(n1);
        System.out.println("n1: " + len);

        len = len(t1);
        System.out.println("t1: " + len);

        ListNode listNode = addTwoNumbers(n1, t1);
        print(listNode);*/

        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;

        ListNode t1 = new ListNode(5);
        ListNode t2 = new ListNode(6);
        ListNode t3 = new ListNode(4);
        ListNode t4 = new ListNode(9);
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;

        int len = len(n1);
        System.out.println("n1: " + len);

        len = len(t1);
        System.out.println("t1: " + len);

        ListNode listNode = addTwoNumbers(n1, t1);
        print(listNode);
    }
}
