package com.caffeaulait;

import java.util.HashMap;
import java.util.Map;

public class _0337_HouseRobberIII {
    /**
     *
     The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

     Determine the maximum amount of money the thief can rob tonight without alerting the police.

     Example 1:

     Input: [3,2,3,null,3,null,1]

     3
     / \
     2   3
     \   \
     3   1

     Output: 7
     Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
     Example 2:

     Input: [3,4,5,1,3,null,1]

     3
     / \
     4   5
     / \   \
     1   3   1

     Output: 9
     Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
     */

    public int rob(TreeNode root) {
        if (root == null) return 0;
        int value = 0;
        if (root.left!=null) {
            value += rob(root.left.left);
            value += rob(root.left.right);
        }
        if (root.right!=null) {
            value += rob(root.right.left);
            value += rob(root.right.right);
        }
        return Math.max(root.val + value, rob(root.left) + rob(root.right));
    }



    public int rob1(TreeNode root) {
        return robHelper(root, new HashMap<>());
    }

    private int robHelper(TreeNode root, Map<TreeNode, Integer> map){
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int value = 0;
        if (root.left!=null) {
            value += robHelper(root.left.left, map);
            value += robHelper(root.left.right, map);
        }
        if (root.right!=null) {
            value += robHelper(root.right.left, map);
            value += robHelper(root.right.right, map);
        }
        int result = Math.max(root.val + value, robHelper(root.left, map) + robHelper(root.right, map));
        map.put(root, result);
        return result;
    }


    public int rob2(TreeNode root) {
        int[] result = robbery(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robbery(TreeNode root){
        int[] result = new int[2];
        if (root == null) return result;
        int[] left = robbery(root.left);
        int[] right = robbery(root.right);
        result[0] = root.val + left[1] + right[1];
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return result;
    }
}
