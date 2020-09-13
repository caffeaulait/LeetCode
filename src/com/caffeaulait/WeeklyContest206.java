package com.caffeaulait;

import java.util.HashSet;
import java.util.Set;

public class WeeklyContest206 {
    /**
     * q1   pass
     * q2   fail
     * q3   fail
     * q4   fail
     */

    public int numSpecial(int[][] mat) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++){
                if (mat[i][j] == 1 && isValid(mat, i, j)) count++;
            }
        }
        return count;
    }

    public boolean isValid(int[][] mat, int x, int y){
        for (int j = 0; j < mat[0].length;j++) {
            //row
            if (j!=y && mat[x][j] == 1) return false;
        }
        for (int i = 0; i < mat.length; i++){
            //col
            if (i!=x && mat[i][y] == 1) return false;
        }
        return true;
    }
}
