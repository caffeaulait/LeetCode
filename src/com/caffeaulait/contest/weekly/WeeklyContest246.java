package com.caffeaulait.contest.weekly;

import java.util.*;

public class WeeklyContest246 {

    public String largestOddNumber(String num) {
        int len = num.length();
        int index = -1;
        for (int i = len - 1; i >=0; i--) {
            if (Integer.parseInt(String.valueOf(num.charAt(i))) % 2 == 1) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return "";
        } else {
            return num.substring(0, index + 1);
        }
    }

    public int numberOfRounds(String startTime, String finishTime) {
        String[] startTimes = startTime.split(":");
        int startHour = Integer.parseInt(startTimes[0]);
        int startMin = Integer.parseInt(startTimes[1]);
        String[] endTimes = finishTime.split(":");
        int endHour = Integer.parseInt(endTimes[0]);
        int endMin = Integer.parseInt(endTimes[1]);
        if (endHour < startHour || (endHour == startHour && endMin < startMin)) endHour += 24;
        if (startMin % 15 > 0) {
            startMin = startMin / 15 * 15 + 15;
        }
        if (endMin % 15 > 0) {
            endMin = endMin / 15 * 15;
        }
        return (endHour - startHour) * 4 + (endMin - startMin) / 15;
    }

    private List<List<Point>> islands = new ArrayList<>();

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        findIslands(grid2);
        int count = 0;
        for (List<Point> island : islands) {
            boolean exist = true;
            for (Point point : island) {
                if (grid1[point.x][point.y] != 1) {
                    exist = false;
                    break;
                }
            }
            if (exist) count++;
        }
        return count;
    }

    public int findIslands(int[][] grid) {
        int result = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    result++;
                    List<Point> points = new ArrayList<>();
                    dfs(grid, i, j, points);
                    if (points.size() > 0) {
                        islands.add(points);
                    }
                }
            }
        }
        return result;
    }

    public void dfs(int[][] grid, int row, int col, List<Point> points) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return;
        }
        grid[row][col]= 0;
        points.add(new Point(row, col));
        dfs(grid, row+1, col, points);
        dfs(grid, row, col+1, points);
        dfs(grid, row-1, col, points);
        dfs(grid, row, col-1, points);
    }

    class Point {
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int[] minDifference(int[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1] + 1;
            result[i] = calcDiff(Arrays.copyOfRange(nums, start, end));
        }
        return result;
    }

    public int calcDiff(int[] nums) {
        int diff = Integer.MAX_VALUE;
        if (nums.length == 0) return diff;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) {
                    diff = Math.min(diff, Math.abs(nums[i] - nums[j]));
                }
            }
        }
        if (diff == Integer.MAX_VALUE) diff = -1;
        return diff;
    }
}
