package com.caffeaulait.problemset;


public class _0167_TwoSumInputArrayIsSorted {
    /**
     * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
     *
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
     *
     * Note:
     *
     * Your returned answers (both index1 and index2) are not zero-based.
     * You may assume that each input would have exactly one solution and you may not use the same element twice.
     * Example:
     *
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers==null || numbers.length<2) return result;
        int i = 0, j = numbers.length-1;
        while (i < j) {
            int value = numbers[i] + numbers[j];
            if (value == target) {
                result[0] = i+1;
                result[1] = j+1;
                return result;
            }else if (value > target){
                j--;
            }else{
                i++;
            }
        }
        return result;
    }
}
