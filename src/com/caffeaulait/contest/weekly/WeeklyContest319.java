package com.caffeaulait.contest.weekly;

import com.caffeaulait.struct.TreeNode;

import java.util.*;

public class WeeklyContest319 {

    public double[] convertTemperature(double celsius) {
        double kelvin = celsius + 273.15;
        double fahrenheit = celsius * 1.80 + 32.00;
        return new double[]{kelvin, fahrenheit};
    }

    public int subarrayLCM(int[] nums, int k) {
        return 0;
    }

    public int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }


    public int minimumOperations(TreeNode root) {
        int res = 0;
        if (root == null) return 0;
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> subList = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                subList.add(node.val);
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
            list.add(subList);
        }
        for (List<Integer> subList : list) {
            res += calcSwaps(subList.stream().mapToInt(i -> i).toArray());
        }
        return res;
    }

    public int calcSwaps(int[] nums) {
        int res = 0;
        int n = nums.length;
        if (n <= 1) return res;
        int[] sorted = Arrays.copyOfRange(nums, 0, n);
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(sorted);
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != sorted[i]) {
                res++;
                int num = nums[i];
                swap(nums, i, map.get(sorted[i]));
                map.put(num, map.get(sorted[i]));
                map.put(sorted[i], i);
            }
        }
        return res;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
