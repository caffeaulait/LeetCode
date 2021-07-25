package com.caffeaulait.problemset;

public class _0042_TrappingRainWater {
    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
     *
     *
     * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
     *
     * Example:
     *
     * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     */

    public int trap(int[] height) {
        if (height.length==0) return 0;
        int result = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[height.length-1] = height[height.length-1];
        for (int i = 1; i< height.length; i++) left[i] = Math.max(left[i-1],height[i]);
        for (int i = height.length-2; i >=0; i--) right[i] = Math.max(right[i+1],height[i]);
        for (int i = 0; i < height.length; i++){
            result += (Math.min(left[i],right[i]) - height[i]);
        }
        return result;
    }
}
