package com.caffeaulait.problemset;

public class _0031_NextPermuation {
    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     *
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
     *
     * The replacement must be in-place and use only constant extra memory.
     *
     * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     *
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     */

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while ( i >=0 && nums[i] >= nums[i+1]) i--; //find first decreasing element
        if (i>=0){
            int j = nums.length-1;
            while (j>=0 && nums[j]<=nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }


    private void reverse(int[] nums, int start){
        int i = start, j = nums.length-1;
        while (i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
