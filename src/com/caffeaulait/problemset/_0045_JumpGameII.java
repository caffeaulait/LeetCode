package com.caffeaulait.problemset;

public class _0045_JumpGameII {
    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     *
     * Each element in the array represents your maximum jump length at that position.
     *
     * Your goal is to reach the last index in the minimum number of jumps.
     *
     * Example:
     *
     * Input: [2,3,1,1,4]
     * Output: 2
     * Explanation: The minimum number of jumps to reach the last index is 2.
     *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Note:
     *
     * You can assume that you can always reach the last index.
     */
    public int jump(int[] nums) {
        int ladder = 0, end = 0, furtherest = 0;
        for (int i = 0;i<nums.length-1;i++){
            furtherest = Math.max(furtherest,nums[i]+i);
            if (i==end){
                end = furtherest;
                ladder++;
            }
        }
        return ladder;
    }

//    [2,3,1,1,1]
//
//    A A A A A
//    - - -
//      - - - -
//        - -
//          -

}
