package com.caffeaulait.problemset;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _0215_KthLargestElementInAnArray {
    /**
     * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
     * not the kth distinct element.
     *
     * Example 1:
     *
     * Input: [3,2,1,5,6,4] and k = 2
     * Output: 5
     * Example 2:
     *
     * Input: [3,2,3,1,2,4,5,5,6] and k = 4
     * Output: 4
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ array's length.
     */
    public int findKthLargest(int[] nums, int k) {
        int result = 0;

        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);

        for (int i : nums){
            queue.add(i);
        }

        while (k>0){
            result = queue.poll();
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int res = new _0215_KthLargestElementInAnArray().findKthLargest2(nums, k);
        System.out.printf("res is: %d", res);
    }

    public int findKthLargest2(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        int n = nums.length;
        // length is 5, to find 1th, nums[4]
        int j = n - k;
        while(lo <= hi) {
            j = partition(nums, lo, hi);
            System.out.printf("num %d is on %d index\n", nums[j], j);
            if( j == n - k) {
                System.out.printf("j is: %d, n is: %d, k is: %d\n", j, n, k);
                break;
            } else if ( j < n - k) {
                lo = j + 1;
            } else {
                hi = j - 1;
            }
        }
        return nums[j];
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo + 1;
        int j = hi;
        int pivot = nums[lo];
        while(i <= j) {
            while(i <= hi && nums[i] < pivot) i++;
            while(j >= lo && nums[j] > pivot) j--;
            //not crossed
            if( i < j ) exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
