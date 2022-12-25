package com.caffeaulait.contest.weekly;

import com.caffeaulait.struct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class WeeklyContest320 {

    public int unequalTriplets(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i + 1; j < nums.length-1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if(nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) sum++;
                }
            }
        }
        return sum;
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            result.add(Arrays.asList(-1,-1));
        }
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node !=null || !stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            values.add(node.val);
            node = node.right;
        }
        for (int i = 0; i < queries.size(); i++) {
            int query = queries.get(i);
            for (int value : values) {
                if (value <= query) {
                    result.get(i).set(0, value);
                }
                if (value >= query) {
                    result.get(i).set(1, value);
                    break;
                }
            }
        }
        return result;
    }


}
