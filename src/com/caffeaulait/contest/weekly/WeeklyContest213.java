package com.caffeaulait.contest.weekly;

import java.util.*;

public class WeeklyContest213 {
    /**
     * q1   pass
     * q2   pass
     * q3   pass
     * q4   fail
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
        return canFormArrayHelper(arr, pieces, 0);
    }
    public boolean canFormArrayHelper(int[] arr, int[][] pieces, int curr) {
        int start = arr[curr];
        int size = 0;
        int idx = 0;
        for (int[] piece: pieces) {
            if (piece[0] == start) {
                size = piece.length;
                break;
            }
            idx++;
        }
        if (size == 0) return false;
        for (int i = 0; i< size; i++) {
            if (arr[curr+i] != pieces[idx][i]) return false;
        }
        if (curr + size == arr.length) return true;
        return canFormArrayHelper(arr, pieces, curr + size);
    }


    int[] end = {1, 1, 1, 1, 1};
    public int countVowelStrings(int n) {
        return countVowelStringsHelper(n, 1);
    }

    public int countVowelStringsHelper(int n, int curr) {
        if (n == curr) return Arrays.stream(end).sum();
        int a = end[0];
        int e = end[1];
        int i = end[2];
        int o = end[3];
        int u = end[4];
        end[0] = a + e + i + o + u;
        end[1] = e + i + o + u;
        end[2] = i + o + u;
        end[3] = o + u;
        end[4] = u;
        return countVowelStringsHelper(n, curr + 1);
    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int acc = 0;
        int i = 0;
        for (i = 0; i < heights.length-1;i++){
            acc += heights[i+1] > heights[i]? heights[i+1] - heights[i] : 0;
            if (acc > bricks){
                if (ladders == 0) {
                    break;
                }
                else {
                    ladders--;
                    acc -= heights[i+1]-heights[i];
                }
            }
        }
        return i;
    }

    List<String> list = new ArrayList<>();
    int[] flag = {0};

    public String kthSmallestPath(int[] destination, int k) {
        int row = destination[0], col = destination[1];
        int total = row + col;
        generate(total, 0, "", row, col, k);
        return list.get(k-1);
    }

    private void generate(int total, int curr, String s, int row,
                          int col, int k) {
        if (flag[0] == 1) return;
        if (curr == total) {
            list.add(s);
            if (list.size() == k) flag[0] = 1;
        }else {
            if (col > 0){
                generate(total, curr + 1, s + "H", row, col - 1, k);
            }
            if (row > 0){
                generate(total, curr + 1, s + "V", row - 1, col, k);
            }
        }
    }
}
