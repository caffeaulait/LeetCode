package com.caffeaulait;

import java.util.*;

public class WeeklyContest195 {

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
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public boolean isPathCrossing(String path) {
        Point curr = new Point(0, 0);
        Set<Point> set = new HashSet<>();
        set.add(curr);
        for (char c : path.toCharArray()){
            int dx = 0, dy = 0;
            switch (c) {
                case 'N':
                    dy = 1;
                    break;
                case 'E':
                    dx = 1;
                    break;
                case 'S':
                    dy = -1;
                    break;
                case 'W':
                    dx = -1;
                    break;
                default:
                    System.err.println("Error");
            }
            curr = new Point(curr.x+dx, curr.y+dy);
            if (set.contains(curr)) return true;
            else set.add(curr);
        }
        return false;
    }

    public boolean canArrange(int[] arr, int k) {
        if (arr.length % 2 == 1) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            int res = arr[i] % k;
            map.put(res, map.getOrDefault(res, 0) + 1);
        }
        for (int i = 0; i < arr.length; i++){
            int res = arr[i] % k;
            if (2 * res  == k) {
                if (map.get(res) % 2 == 1)
                    return false;
            }else if (res == 0) {
                if (map.get(res) % 2 == 1)
                    return false;
            }else{
                if (map.get(res) != map.get(k-res))
                    return false;
            }
        }
        return true;
    }
}
