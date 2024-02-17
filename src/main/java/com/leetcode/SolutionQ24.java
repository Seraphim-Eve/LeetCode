package com.leetcode;

/**
 * 24. Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SolutionQ24 {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int data) {
            this.val = data;
        }

        public ListNode(int data, ListNode node) {
            this.val = data;
            this.next = node;
        }
    }
}
