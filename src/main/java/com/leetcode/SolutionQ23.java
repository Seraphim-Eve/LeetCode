package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class SolutionQ23 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);
            }
        }

        if (heap.isEmpty()) {
            return null;
        }

        ListNode least = heap.poll();
        if (least != null && least.next != null) {
            heap.add(least.next);
        }
        ListNode pre = least;
        if (pre != null) {
            while (!heap.isEmpty()) {
                ListNode cur = heap.poll();
                if (cur != null) {
                    pre.next = cur;
                    pre = cur;
                    if (cur.next != null) {
                        heap.add(cur.next);
                    }
                }
            }
        }
        return least;
    }

    public static void main(String[] args) {

    }
}
