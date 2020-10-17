package com.caffeaulait;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BiWeeklyContest37 {
    /**
     * q1
     * q2
     * q3
     * q4
     */

    public double trimMean(int[] arr) {
        int size = arr.length / 20;
        Arrays.sort(arr);
        int sum = 0;
        for (int i = size; i < arr.length - size; i++) sum+=arr[i];
        return sum * 1.0 / (arr.length - 2 * size);
    }

    public int[] bestCoordinate(int[][] towers, int radius) {
        Arrays.sort(towers, (a, b) ->  a[0] == b[0] ? a[1] - b[1] :
                a[0] - b[0]);
        int[] res = new int[] {0, 0};
        int curr;
        int max = 0;
        for (int i = 0; i < towers.length; i++) {
            curr = 0;
            for (int j = 0; j < towers.length; j++) {
                int dx = towers[i][0] - towers[j][0];
                int dy = towers[i][1] - towers[j][1];
                double dis = Math.sqrt(dx*dx + dy*dy);
                if (dis <= radius) curr += towers[j][2] / (1 + dis);
            }
            if (curr > max) {
                res[0] = towers[i][0];
                res[1] = towers[i][1];
                max = curr;
            }
        }
        return res;
    }

}
