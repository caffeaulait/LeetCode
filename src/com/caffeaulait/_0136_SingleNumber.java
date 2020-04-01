package com.caffeaulait;

import java.util.HashSet;
import java.util.Set;

public class _0136_SingleNumber {
    /**
     * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
     *
     * Note:
     *
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     *
     * Example 1:
     *
     * Input: [2,2,1]
     * Output: 1
     * Example 2:
     *
     * Input: [4,1,2,1,2]
     * Output: 4
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int el : nums) {
            if (!set.contains(el)){
                set.add(el);
            }else{
                set.remove(el);
            }
        }
        return (int)set.toArray()[0];
    }

    public int singleNumber2(int[] nums){
        int result = 0;
        for (int el : nums){
            result = result ^ el;
        }
        return result;
    }
}
