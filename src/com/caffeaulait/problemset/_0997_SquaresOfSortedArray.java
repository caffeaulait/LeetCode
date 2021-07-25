package com.caffeaulait.problemset;

public class _0997_SquaresOfSortedArray {
    /**
     * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
     *
     *
     *
     * Example 1:
     *
     * Input: [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     * Example 2:
     *
     * Input: [-7,-3,2,3,11]
     * Output: [4,9,9,49,121]
     *
     *
     * Note:
     *
     * 1 <= A.length <= 10000
     * -10000 <= A[i] <= 10000
     * A is sorted in non-decreasing order.
     */
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int lo = 0, hi = n - 1;
        int[] result = new int[n];
        for (int i = n-1; i >=0; i--){
            if (Math.abs(A[lo]) > Math.abs(A[hi])){
                result[i] = A[lo] * A[lo];
                lo++;
            }else {
                result[i] = A[hi] * A[hi];
                hi--;
            }
        }
        return result;
    }
}
