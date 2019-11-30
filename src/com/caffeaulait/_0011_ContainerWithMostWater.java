package com.caffeaulait;

public class _0011_ContainerWithMostWater {

    /**
     * #11
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
     * which together with x-axis forms a container, such that the container contains the most water.
     *
     * Note: You may not slant the container and n is at least 2.
     *
     */

// If we try to move the pointer at the longer line inwards, we won't gain any increase in area,
// since it is limited by the shorter line. But moving the shorter line's pointer could turn out
// to be beneficial, as per the same argument, despite the reduction in the width.
    public int maxArea(int[] height){
        int maxarea = 0;
        int l = 0, r = height.length-1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l],height[r]) * (r - l));
            if (height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxarea;
    }
}
