package com.caffeaulait.problemset;

import java.util.*;

public class _0398_RandomPickIndex {
    /**
     * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
     *
     * Note:
     * The array size can be very large. Solution that uses too much extra space will not pass the judge.
     *
     * Example:
     *
     * int[] nums = new int[] {1,2,3,3,3};
     * Solution solution = new Solution(nums);
     *
     * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
     * solution.pick(3);
     *
     * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
     * solution.pick(1);
     */

    class Solution {

        private Map<Integer, List<Integer>> map;
        private Random random;

        public Solution(int[] nums) {
            this.random = new Random();
            this.map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (!this.map.containsKey(nums[i])) {
                    this.map.put(nums[i], new ArrayList<>());
                }
                this.map.get(nums[i]).add(i);
            }
        }

        public int pick(int target) {
            int size = map.get(target).size();
            return map.get(target).get(random.nextInt(size));
        }
    }
}
