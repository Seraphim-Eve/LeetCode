package com.class2;

import java.util.HashMap;

public class Day2 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        System.out.println(map.get(111));
    }

    /**
     * reverse simple linked list
     * @param head head
     * @return head
     */
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * reverse simple double linked list
     * @param head head
     * @return head
     */
    public static DoubleNode reverseDoubleLinkedList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next;
        while (head != null) {
            next = head.next;

            head.next = pre;
            head.last = next;

            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * delete specific num from the node
     * @param head node
     * @param num specific num
     * @return the rest of nodes
     */
    public static Node deleteNode(Node head, int num) {
        //try to find the num that comes first time.
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }

        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + ((r - l) >> 1);
        int left = process(arr, l, mid);
        int right = process(arr, mid + 1, r);
        return Math.max(left, right);
    }
}
