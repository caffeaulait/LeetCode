package com.caffeaulait.problemset;

public class _0845_LongestMountainInArray {
    /**
     *
     Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

     B.length >= 3
     There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
     (Note that B could be any subarray of A, including the entire array A.)

     Given an array A of integers, return the length of the longest mountain.

     Return 0 if there is no mountain.

     Example 1:

     Input: [2,1,4,7,3,2,5]
     Output: 5
     Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
     Example 2:

     Input: [2,2,2]
     Output: 0
     Explanation: There is no mountain.
     */

    public int longestMountain(int[] A) {
        if (A == null || A.length < 3) return 0;
        int ans = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i-1] && A[i] > A[i+1]) {
                int left = i - 1;
                while (left > 0 && A[left-1] < A[left]) left--;
                int right = i + 1;
                while (right < A.length - 1 && A[right + 1] < A[right]) right++;
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }
}
