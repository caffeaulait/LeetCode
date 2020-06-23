package com.caffeaulait;

import java.util.HashMap;
import java.util.Map;

public class WeeklyContest194 {
    /**
     * q1   pass
     * q2   fail
     * q3   fail
     * q4   fail
     */
    public int xorOperation(int n, int start) {
        int result = start;
        for (int i = 1; i <  n; i++){
            result ^= (start + 2*i);
        }
        return result;
    }

    public String[] getFolderNames(String[] names) {
        return names;
    }
}
