package com.caffeaulait.problemset;

import com.caffeaulait.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _0530_MinimumAbsoluteDifferenceInBST {
    /**
     * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
     *
     * Example:
     *
     * Input:
     *
     *    1
     *     \
     *      3
     *     /
     *    2
     *
     * Output:
     * 1
     *
     * Explanation:
     * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
     */

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        List<Integer> list = new ArrayList<>();
        toList(root, list);
        Object[] arr = list.toArray();
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1;i++){
            diff = Math.min(diff, (int)arr[i+1]-(int)arr[i]);
        }
        return diff;
    }

    private void toList(TreeNode root, List<Integer> list){
        if (root == null) return;
        toList(root.left, list);
        list.add(root.val);
        toList(root.right, list);
    }
}
