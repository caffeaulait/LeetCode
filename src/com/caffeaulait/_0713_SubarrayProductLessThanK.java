package com.caffeaulait;

public class _0713_SubarrayProductLessThanK {
    /**
     *
     Your are given an array of positive integers nums.

     Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

     Example 1:
     Input: nums = [10, 5, 2, 6], k = 100
     Output: 8
     Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
     Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
     */

    public int numSubarrayProductLessThanK(int[] nums, int k) {
//        int count = 0;
//        for (int i = 0; i < nums.length; i++){
//            int product = 1;
//            for (int j = i; j < nums.length; j++){
//                product *= nums[j];
//                if (product < k) count++;
//                else break;
//            }
//        }
//        return count;
        if (k == 0) return 0;
        int count = 0;
        int product = 1;
        for (int i = 0, j = 0; j < nums.length; j++){
            product *= nums[j];
            while ( i <= j && product >=k) {
                product /= nums[i++];
            }
            count += j - i + 1;
        }
        return count;
    }
}
