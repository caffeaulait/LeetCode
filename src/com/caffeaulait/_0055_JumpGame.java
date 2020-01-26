package com.caffeaulait;

public class _0055_JumpGame {
    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     *
     * Each element in the array represents your maximum jump length at that position.
     *
     * Determine if you are able to reach the last index.
     *
     * Example 1:
     *
     * Input: [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     *
     * Input: [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum
     * jump length is 0, which makes it impossible to reach the last index.
     */


    /*
    1. Naive Approach
     */
//    public boolean canJump(int[] nums) {
//        return canJumpFrom(0,nums);
//    }
//
//    public boolean canJumpFrom(int position, int[] nums){
//        if (position==nums.length-1)
//            return true;
//        int furthest = Math.min(position+nums[position], nums.length-1);
//        for (int next = position+1;next<=furthest;next++){
//            if (canJumpFrom(next,nums))
//                return true;
//        }
//        return false;
//    }

    /*
    2. DP top-down
     */
//    enum Index {GOOD, BAD, UNKNOWN}
//
//    Index[] memo;

//    public boolean canJump(int[] nums){
//        memo = new Index[nums.length];
//        for (int i = 0; i<memo.length-1;i++){
//            memo[i] = Index.UNKNOWN;
//        }
//        memo[nums.length-1] = Index.GOOD;
//        return canJumpFrom(0,nums);
//    }
//
//    public boolean canJumpFrom(int position, int[] nums){
//        if (memo[position] != Index.UNKNOWN)
//            return memo[position] == Index.GOOD ? true : false;
//        int furthest = Math.min(position+nums[position], nums.length-1);
//        for (int next = position+1;next<=furthest;next++){
//            if (canJumpFrom(next,nums))
//                memo[position] = Index.GOOD;
//                return true;
//        }
//        memo[position] = Index.BAD;
//        return false;
//    }


    /*
    3. DP bottom-up
     */
//    enum Index {GOOD, BAD, UNKNOWN}
//
//    public boolean canJump(int[] nums){
//        Index[] memo = new Index[nums.length];
//        for (int i = 0; i<memo.length;i++){
//            memo[i] = Index.UNKNOWN;
//        }
//        memo[memo.length - 1] = Index.GOOD;
//
//        for (int i = nums.length - 2; i>=0; i--){
//            int furthest = Math.min(i + nums[i], nums.length-1);
//            for (int j = i + 1; j<=furthest;j++){
//                if (memo[j] == Index.GOOD){
//                    memo[i] = Index.GOOD;
//                    break;
//                }
//            }
//        }
//        return memo[0] == Index.GOOD;
//    }

    public boolean canJump(int[] nums){
        int lastGood = nums.length - 1;
        for (int i = nums.length-1;i>=0;i--){
            if (i+nums[i] >= lastGood){
                lastGood = i;
            }
        }
        return lastGood == 0;
    }
}
