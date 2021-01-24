package com.caffeaulait;

import java.util.ArrayList;
import java.util.List;

public class WeeklyContest225 {

    public String maximumTime(String time) {
        String[] strs = time.split(":");
        String hour = strs[0];
        String min = strs[1];
        int maxHour = 0;
        int maxMin = 0;
        for (char c = '0'; c <= '9'; c++){
            String candidate = hour.replaceAll("\\?", String.valueOf(c));
            if (isValid(Integer.parseInt(candidate), true))
                maxHour = Math.max(maxHour, Integer.parseInt(candidate));
        }
        for (char c = '0'; c <= '9'; c++){
            String candidate = min.replaceAll("\\?", String.valueOf(c));
            if (isValid(Integer.parseInt(candidate), false))
                maxMin = Math.max(maxMin, Integer.parseInt(candidate));
        }
        String maxHourStr = (maxHour < 10 ? "0" : "") + maxHour;
        String maxMinStr = (maxMin < 10 ? "0" : "") + maxMin;
        if (hour.equals("??")){
            maxHourStr = "23";
        }
        if (min.equals("??")) {
            maxMinStr = "59";
        }
        return maxHourStr +":" + maxMinStr;
    }

    private boolean isValid(int time, boolean isHour) {
        if (isHour) {
            return time >=0 && time <= 23;
        }else {
            return time >=0 && time <= 59;
        }
    }

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] arr = new int[m][n];
        arr[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) arr[i][0] = arr[i-1][0] ^ matrix[i][0];
        for (int j = 1; j < n; j++) arr[0][j] = arr[0][j-1] ^ matrix[0][j];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < m ; i++){
            for (int j = 1; j < n; j++){
                if (j == 1) {
                    arr[i][1] = arr[i-1][1] ^ matrix[i][0] ^ matrix[i][1];
                }else {
                    arr[i][j] = arr[i][j-1];
                    for (int z = 0 ; z <= i; z++) {
                        arr[i][j] ^= matrix[z][j];
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) list.add(arr[i][j]);
        }
        list.sort((a,b) -> (b-a));
        return list.get(k-1);
    }
}
