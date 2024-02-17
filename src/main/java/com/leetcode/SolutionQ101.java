package com.leetcode;

/**
 * 101. Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree
 */
public class SolutionQ101 {
    /*
      Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return isSym(root, root);
    }

    public boolean isSym(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSym(p.left, q.right) && isSym(p.right, q.left);
    }
}
