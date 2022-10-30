package com.caffeaulait.contest.weekly;

import java.util.*;

public class WeeklyContest317 {

    public int averageValue(int[] nums) {
        int sum = 0;
        int cnt = 0;
        for (int num : nums) {
            if (num % 2 == 0 && num % 3 == 0) {
                sum += num;
                cnt++;
            }
        }
        return cnt > 0 ? sum / cnt : 0;
    }

    class Video {
        String id;
        int view;
        public Video(String id, int view) {
            this.id = id;
            this.view = view;
        }
    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> result = new ArrayList<>();
        if(creators.length == 0) return result;
        Map<String, Integer> scores = new HashMap<>();
        Map<String, List<Video>> map = new HashMap<>();
        for(int i = 0; i < creators.length; i++) {
            String creator = creators[i];
            String id = ids[i];
            int view = views[i];
            if(!map.containsKey(creator)) {
                map.put(creator, new ArrayList<>());
                scores.put(creator, 0);
            }
            scores.put(creator, scores.get(creator)+view);
            map.get(creator).add(new Video(id, view));
        }
        int max = 0;
        List<String> maxCreators = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : scores.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        for(Map.Entry<String, Integer> entry : scores.entrySet()) {
            if(entry.getValue() == max) {
                maxCreators.add(entry.getKey());
            }
        }
        for(String s : maxCreators) {
            List<Video> videos = map.get(s);
            Queue<Video> heap = new PriorityQueue<>((a,b) -> b.view-a.view);
            heap.addAll(videos);
            result.add(Arrays.asList(s, heap.poll().id));
        }
        return result;
    }

    public long makeIntegerBeautiful(long n, int target) {
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            if (digitSum(n+i) <= target) return i;
        }
        return -1;
    }

    public int digitSum(long n) {
        int sum = 0;
        while ( n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
