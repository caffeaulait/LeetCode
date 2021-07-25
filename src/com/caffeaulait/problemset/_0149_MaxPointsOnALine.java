package com.caffeaulait.problemset;

import java.util.HashMap;
import java.util.Map;

public class _0149_MaxPointsOnALine {
//    /**
//     * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
//     *
//     * Example 1:
//     *
//     * Input: [[1,1],[2,2],[3,3]]
//     * Output: 3
//     * Explanation:
//     * ^
//     * |
//     * |        o
//     * |     o
//     * |  o
//     * +------------->
//     * 0  1  2  3  4
//     * Example 2:
//     *
//     * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//     * Output: 4
//     * Explanation:
//     * ^
//     * |
//     * |  o
//     * |     o        o
//     * |        o
//     * |  o        o
//     * +------------------->
//     * 0  1  2  3  4  5  6
//     */

    public int maxPoints(int[][] points) {
        if (points.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < points.length; i++){
            Map<String,Integer> map = new HashMap<>();
            int duplicate = 0;
            int max = 0;
            for (int j = i + 1; j < points.length; j++){
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                if (dx == 0 && dy == 0) {
                    duplicate++;
                    continue;
                }
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                map.put(dx + "/" + dy, map.getOrDefault(dx + "/" + dy, 0) + 1);
                max = Math.max(max, map.get(dx + "/" + dy));
            }
            res = Math.max(res, max + duplicate + 1);
        }
        return res;
    }

    public int gcd(int a, int b){
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
