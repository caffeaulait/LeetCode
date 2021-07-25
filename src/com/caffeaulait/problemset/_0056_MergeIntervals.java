package com.caffeaulait.problemset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _0056_MergeIntervals {
    /**
     * Given a collection of intervals, merge all overlapping intervals.
     *
     * Example 1:
     *
     * Input: [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     * Example 2:
     *
     * Input: [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
     */

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int[] curr = intervals[0];
        result.add(curr);

        for (int i = 1; i < intervals.length; i++){
            if (curr[1] >= intervals[i][0]){
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }else{
                curr = intervals[i];
                result.add(curr);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
