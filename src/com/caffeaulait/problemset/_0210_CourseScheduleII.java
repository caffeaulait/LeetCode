package com.caffeaulait.problemset;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _0210_CourseScheduleII {
    /**
     * There are a total of n courses you have to take labelled from 0 to n - 1.
     *
     * Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.
     *
     * Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.
     *
     * If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
     *
     *
     *
     * Example 1:
     *
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: [0,1]
     * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
     * Example 2:
     *
     * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
     * Output: [0,2,1,3]
     * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
     * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
     * Example 3:
     *
     * Input: numCourses = 1, prerequisites = []
     * Output: [0]
     */

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        int res[] = new int[numCourses];
        int index = 0;
        for (int[] prerequisite : prerequisites) {
            //need other courses
            int post = prerequisite[0];
            map.put(post, map.getOrDefault(post, 0) + 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!map.containsKey(i)) {
                res[index++] = i;
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int prerequisite = queue.poll();
            for (int i = 0; i < prerequisites.length; i++){
                int post = prerequisites[i][0];
                int pre = prerequisites[i][1];
                if (pre == prerequisite) {
                    map.put(post, map.get(post)-1);
                    if (map.get(post) == 0) {
                        res[index++] = post;
                        queue.offer(post);
                    }
                }
            }
        }
        return index == numCourses ? res : new int[]{};
    }
}
