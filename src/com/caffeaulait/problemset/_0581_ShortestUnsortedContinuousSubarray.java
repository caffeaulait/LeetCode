package com.caffeaulait.problemset;

import java.util.Arrays;

public class _0581_ShortestUnsortedContinuousSubarray {
    /**
     * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
     *
     * You need to find the shortest such subarray and output its length.
     *
     * Example 1:
     * Input: [2, 6, 4, 8, 10, 9, 15]
     * Output: 5
     * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
     * Note:
     * Then length of the input array is in range [1, 10,000].
     * The input array may contain duplicates, so ascending order here means <=.
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);

        int start = 0, end = n-1;
        while (start < n && nums[start] == arr[start]) start++;
        while (end > start && nums[end] == arr[end]) end--;
        return end-start+1;
    }
}
