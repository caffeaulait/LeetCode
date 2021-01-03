package com.caffeaulait;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WeeklyContest222 {
    /**
     * q1
     * q2
     * q3
     * q4
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;
        int i = 0;
        Arrays.sort(boxTypes, (a,b) -> (b[1] - a[1]));
        while ( truckSize > 0 && i < boxTypes.length) {
            int[] box = boxTypes[i];
            if (box[0] <= truckSize) {
                res += box[0] * box[1];
                truckSize-=box[0];
            }else {
                res += truckSize * box[1];
                truckSize=0;
            }
            i++;
        }
        return res;
    }

    private boolean isPowerOfTwo(int x) {
        return x!=0 && ((x&(x-1)) == 0);
    }

    Map<Integer, Boolean> map = new HashMap<>();

    public int countPairs(int[] deliciousness) {
        double res = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = i+1; j < deliciousness.length; j++) {
                int sum = deliciousness[i] + deliciousness[j];
                if(map.containsKey(sum)) {
                    if (map.get(sum)) res++;
                }else {
                    if (isPowerOfTwo(sum)) {
                        res++;
                        map.put(sum, true);
                    }else {
                        map.put(sum, false);
                    }
                }
            }
        }
        return (int) (res % (10e+7));
    }

    public int waysToSplit(int[] nums) {
        return 0;
    }
}
