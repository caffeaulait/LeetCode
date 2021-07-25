package com.caffeaulait.contest.biweekly;

import java.util.LinkedList;
import java.util.Queue;

public class BiWeeklyContest56 {

    public int countTriples(int n) {
        int count = 0;
        for (int i = 5; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                for (int k = 1; k < i; k++) {
                    if (j*j + k*k == i*i) count++;
                }
            }
        }
        return count;
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1], depth = pos[2];
            visited[x][y] = true;
            if (depth != 0) {
                if (x == 0 || x == m-1 || y == 0 || y == n-1) {
                    return depth;
                }
            }
            if (x >= 1 && maze[x-1][y] == '.' && !visited[x-1][y]) {
                queue.offer(new int[]{x-1, y, depth+1});
            }
            if (y < n - 1 && maze[x][y+1] == '.' && !visited[x][y+1]) {
                queue.offer(new int[]{x, y+1, depth+1});
            }
            if (y >= 1 && maze[x][y-1] == '.' && !visited[x][y-1]) {
                queue.offer(new int[]{x, y-1, depth+1});
            }
            if (x < m - 1 && maze[x+1][y] == '.' && !visited[x+1][y]) {
                queue.offer(new int[]{x+1, y, depth+1});
            }
        }
        return -1;
    }

}
