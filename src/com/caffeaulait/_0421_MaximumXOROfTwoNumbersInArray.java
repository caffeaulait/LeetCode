package com.caffeaulait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0421_MaximumXOROfTwoNumbersInArray {
    /**
     * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
     *
     * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
     *
     * Could you do this in O(n) runtime?
     *
     * Example:
     *
     * Input: [3, 10, 5, 25, 2, 8]
     *
     * Output: 28
     *
     * Explanation: The maximum result is 5 ^ 25 = 28.
     */
    public int findMaximumXOR(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i<nums.length-1;i++){
            for (int j=i; j<nums.length;j++){
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        return max;
    }
}
