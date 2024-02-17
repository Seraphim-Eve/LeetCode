package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 * https://leetcode.com/problems/path-sum-ii/
 */
public class SolutionQ113 {

    public static class TreeNode {
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> all = new ArrayList<>();
        if (root == null) {
            return all;
        }
        ArrayList<Integer> pathValues = new ArrayList<>();
        process(root, 0, targetSum, all, pathValues);
        return all;
    }

    public static void process(TreeNode x, int preSum, int sum, List<List<Integer>> all, List<Integer> values) {
        if (x.left == null && x.right == null) {
            if (x.val + preSum == sum) {
                values.add(x.val);
                all.add(new ArrayList<>(values));
                values.remove(values.size() - 1);
            }
        }
        preSum += x.val;
        if (x.left != null) {
            values.add(x.val);
            process(x.left, preSum, sum, all, values);
        }
        if (x.right != null) {
            values.add(x.val);
            process(x.right, preSum, sum, all, values);
        }
    }
}
