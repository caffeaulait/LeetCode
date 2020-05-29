package com.caffeaulait;

import java.util.LinkedList;
import java.util.Queue;

public class _0207_CourseSchedule {
    /**
     *There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
     *
     * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
     *
     * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
     *
     *
     *
     * Example 1:
     *
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     *              To take course 1 you should have finished course 0. So it is possible.
     * Example 2:
     *
     * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     *              To take course 1 you should have finished course 0, and to take course 0 you should
     *              also have finished course 1. So it is impossible.
     *
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] matrix = new boolean[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++){
            int next = prerequisites[i][0];
            int prev = prerequisites[i][1];
            if (!matrix[prev][next]) indegree[next]++;
            matrix[prev][next] = true;
        }

        int count = 0;
        Queue<Integer> q= new LinkedList<>();
        for (int i = 0; i < indegree.length; i++){
            if (indegree[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int course = q.poll();
            count++;
            for (int i = 0; i < numCourses; i++){
                if (matrix[course][i]) {
                    if (--indegree[i] == 0) q.offer(i);
                }
            }
        }

        return count == numCourses;
    }
}
