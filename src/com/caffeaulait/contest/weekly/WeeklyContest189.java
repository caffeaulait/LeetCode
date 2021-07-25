package com.caffeaulait.contest.weekly;

import java.util.*;

public class WeeklyContest189 {
    /**
     * q1   pass
     * q2   pass
     * q3   pass
     * q4   fail
     */

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++){
            if (queryTime>=startTime[i] && queryTime <= endTime[i]) count++;
        }
        return count;
    }

    public String arrangeWords(String text) {
        Queue<MyString> pq = new PriorityQueue<>(new Comparator<MyString>() {
            @Override
            public int compare(MyString o1, MyString o2) {
                if (o1.string.length() < o2.string.length()) return -1;
                else if (o1.string.length() > o2.string.length()) return 1;
                else return o1.index - o2.index;
            }
        });
        String[] strs = text.split(" ");
        int index = 0;
        for (String str : strs){
            str = str.toLowerCase();
            pq.add(new MyString(str, index++));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            sb.append(pq.poll().string);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        String f = sb.substring(0,1);
        sb.replace(0,1, f.toUpperCase());
        return sb.toString();
    }

    class MyString{
        String string;
        int index;
        public MyString(String string, int index){
            this.string = string;
            this.index = index;
        }
    }

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Set<String>> list = new ArrayList<>();
        for (List<String> item : favoriteCompanies){
            list.add(new HashSet<>(item));
        }
        boolean isSubset = false;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            isSubset = false;
            for (int j = 0; j < list.size(); j++){
                if (j == i) continue;
                if (list.get(j).containsAll(list.get(i))) {
                    isSubset = true;
                    break;
                }
            }
            if (!isSubset) result.add(i);
        }
        return result;
    }

    public int numPoints(int[][] points, int r) {
        int count = 0;
        return 0;
    }

}
