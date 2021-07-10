package com.caffeaulait;

import java.util.Collections;

public class _0004_MedianOfTwoSortedArrays {
    /**
     * #4
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     *
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     *
     * You may assume nums1 and nums2 cannot be both empty.
     *
     * Example 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * The median is 2.0
     * Example 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * The median is (2 + 3)/2 = 2.5
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int[] merged = new int[l1+l2];
        int total = l1 + l2;
        int i=0, j =0, m = 0;
        while (i<l1 && j<l2){
            if (nums1[i] <= nums2[j]){
                merged[m++] = nums1[i++];
            }else{
                merged[m++] = nums2[j++];
            }
        }
        if (i == l1){
            while ( m < total ){
                merged[m++] = nums2[j++];
            }
        }else{
            while (m < total){
                merged[m++] = nums1[i++];
            }
        }

        if (total % 2 != 0){
            return merged[m/2];
        }else{
            return (merged[m/2]+merged[m/2-1])/2.0;
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return 0.0;
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, l) + findKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    public double findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) return nums2[start2+k-1];
        if (start2 >= nums2.length) return nums1[start1+k-1];
        if (k==1) return Math.min(nums1[start1], nums2[start2]);
        int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE;
        if (start1+k/2-1 < nums1.length) mid1 = nums1[start1+k/2-1];
        if (start2+k/2-1 < nums2.length ) mid2 = nums2[start2+k/2-1];
        if (mid1 < mid2) {
            return findKth(nums1, start1+k/2, nums2, start2, k-k/2);
        } else {
            return findKth(nums1, start1, nums2, start2+k/2, k-k/2);
        }
    }
}
