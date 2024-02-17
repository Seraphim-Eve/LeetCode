package com.leetcode;

import java.util.HashMap;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class SolutionQ105 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        //return f1(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueIndexMap.put(inorder[i], i);
        }
        return f2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valueIndexMap);
    }

    public TreeNode f1(int[] pre, int pl, int pr, int[] ino, int il, int ir) {
        if (pl > pr) {
            return null;
        }
        TreeNode head = new TreeNode(pre[pl]);
        if (pl == pr) {
            return head;
        }

        int find = il;
        while (ino[find] != pre[pl]) {
            find++;
        }

        head.left = f1(pre, pl + 1, pl + find - il, ino, il, find - 1);
        head.right = f1(pre, pl + find - il + 1, pr, ino, find + 1, ir);
        return head;
    }

    public TreeNode f2(int[] pre, int pl, int pr, int[] ino, int il, int ir, HashMap<Integer, Integer> valueIndexMap) {
        if (pl > pr) {
            return null;
        }
        TreeNode head = new TreeNode(pre[pl]);
        if (pl == pr) {
            return head;
        }
        int find = valueIndexMap.get(pre[pl]);
        head.left = f2(pre, pl + 1, pl + find - il, ino, il, find - 1, valueIndexMap);
        head.right = f2(pre, pl + find - il + 1, pr, ino, find + 1, ir, valueIndexMap);
        return head;
    }


    public static void main(String[] args) {
        System.out.println(Math.pow(2, 8));
    }
}
