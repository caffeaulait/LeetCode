package com.caffeaulait;

import java.util.*;

public class BiweeklyContest36 {
    /**
     * q1   pass
     * q2   pass
     * q3   fail
     * q4   fail
     */

    int[] capacity;

    public BiweeklyContest36(int big, int medium, int small) {
        capacity = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if (capacity[carType-1] > 0) {
            capacity[carType-1]--;
            return true;
        }
        return false;
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            if (!map.containsKey(keyName[i])) {
                map.put(keyName[i], new ArrayList<>());
            }
            map.get(keyName[i]).add(keyTime[i]);
        }
        List<String> res = new ArrayList<>();
        for (String name : map.keySet()) {
            List<String> time = map.get(name);
            Collections.sort(time);
            if (isAlert(time)) res.add(name);
        }
        Collections.sort(res);
        return res;
    }

    public boolean isAlert(List<String> list) {
        if (list.size() < 3) return false;
        for (int i = 2; i < list.size();i++){
            if (elapsed(list.get(i-2), list.get(i)) <= 60) return true;
        }
        return false;
    }

    private int elapsed(String s1, String s2) {
        int s1_hr = Integer.parseInt(s1.substring(0, 2));
        int s2_hr = Integer.parseInt(s2.substring(0, 2));
        int s1_min = Integer.parseInt(s1.substring(3));
        int s2_min = Integer.parseInt(s2.substring(3));
        if (s2_hr > s1_hr) return (s2_hr - s1_hr)*60+s2_min-s1_min;
        else if (s2_hr == s1_hr) return s2_min-s1_min;
        else return Integer.MAX_VALUE;
    }
}
