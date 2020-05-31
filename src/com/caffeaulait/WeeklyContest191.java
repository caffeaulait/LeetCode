package com.caffeaulait;

import java.util.Arrays;

public class WeeklyContest191 {
    /**
     * q1   pass
     * q2   fail
     * q3   fail
     * q4   fail
     */

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 2) return (nums[0]-1) * (nums[1]-1);
        int min1 = nums[0] - 1;
        int min2 = nums[1] - 1;
        int max1 = nums[nums.length-1] - 1;
        int max2= nums[nums.length-2] - 1;
        return Math.max(min1*min2, max1*max2);
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxH = horizontalCuts[0];
        int maxW = verticalCuts[0];

        for (int i = 0; i < horizontalCuts.length-1; i++){
            maxH = Math.max(maxH,horizontalCuts[i+1] - horizontalCuts[i]);
        }
        maxH = Math.max(maxH,(h - horizontalCuts[horizontalCuts.length-1]));

        for (int i = 0; i < verticalCuts.length-1; i++){
            maxW = Math.max(maxW,verticalCuts[i+1] - verticalCuts[i]);
        }
        maxW = Math.max(maxW,(w - verticalCuts[verticalCuts.length-1]));

        return (int) ((maxH * maxW) % (10e9+7));
    }
}
