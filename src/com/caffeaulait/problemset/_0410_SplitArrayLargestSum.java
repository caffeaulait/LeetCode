package com.caffeaulait.problemset;

public class _0410_SplitArrayLargestSum {
    /**
     * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty
     * continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
     */

    public int splitArray(int[] nums, int m) {
        int sum =0, max = Integer.MIN_VALUE;
        for (int el : nums) {
            max = Math.max(max, el);
            sum += el;
        }
        if (m == 1) return sum;
        int lo = max, hi = sum;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (canSplit(nums, m, mid)){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canSplit(int[] nums, int m, int target){
        int count = 1;
        int sum = 0;
        for (int el : nums){
            sum += el;
            if (sum > target) {
                sum = el;
                count++;
                if (count > m) return false;
            }
        }
        return true;
    }
}
