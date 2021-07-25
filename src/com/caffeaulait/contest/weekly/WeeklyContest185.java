package com.caffeaulait.contest.weekly;

import java.math.BigInteger;
import java.util.*;

public class WeeklyContest185 {
    /**
     *  q1 pass
     *  q2 pass
     *  q3 fail
     *  q4 fail
     */
    public String reformat(String s) {
        List<Character> chars = new ArrayList<>();
        List<Character> nums = new ArrayList<>();
        for (int i = 0; i < s.length();i++) {
            char c = s.charAt(i);
            if (c >= '0' && c<='9') nums.add(c);
            else chars.add(c);
        }
        int char_count = chars.size(), num_count = nums.size();
        StringBuilder sb = new StringBuilder();
        if (Math.abs(char_count-num_count)>1) return "";
        int i = 0, j = 0;
        if (char_count >= num_count) {
            while (i<char_count || j < num_count) {
                if (i < char_count) {
                    sb.append(chars.get(i++));
                }
                if (j < num_count) {
                    sb.append(nums.get(j++));
                }
            }
        } else {
            while (i<char_count || j < num_count) {
                if (j < num_count) {
                    sb.append(nums.get(j++));
                }
                if (i < char_count) {
                    sb.append(chars.get(i++));
                }
            }
        }
        return sb.toString();
    }


    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<String> set = new TreeSet<>();
        TreeMap<Integer, Map<String, Integer>> map = new TreeMap<>();
        for (List<String> order : orders) {
            int tableNo = Integer.parseInt(order.get(1));
            String item = order.get(2);
            set.add(item);
            if (!map.containsKey(tableNo)) {
                Map<String, Integer> items = new HashMap<>();
                items.put(item,1);
                map.put(tableNo, items);
            } else {
                Map<String, Integer> items = map.get(tableNo);
                items.put(item, items.getOrDefault(item, 0)+1);
            }
        }
        List<List<String>> result = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(set);
        result.add(header);
        for ( int num : map.keySet()) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(num));
            for (String item : set) {
                if (map.get(num).containsKey(item)) {
                    row.add(String.valueOf(map.get(num).get(item)));
                }else{
                    row.add("0");
                }
            }
            result.add(row);
        }
        return result;
    }

    public static int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0, r = 0, o =0, a = 0, k = 0;
        for (int i = 0; i < croakOfFrogs.length();i++){
            char ch = croakOfFrogs.charAt(i);
            if (ch == 'c') c++;
            else if (ch == 'r') r++;
            else if (ch == 'o') o++;
            else if (ch == 'a') a++;
            else if (ch == 'k') k++;
            else return -1;
        }
        if (r!=c || o!=c || a!=c || k!=c) return -1;
        int full = (croakOfFrogs.split("croak", -1).length) - 1;
        return full;
    }

    public int numOfArrays(int n, int m, int k) {
        BigInteger ans = BigInteger.ONE;
        //range 1 ~ m
        if (m < k) return 0;
        // k increase where last increase number is m
        return binomial(m-1, k-1).multiply(binomial(n, m)).divide(new BigInteger("100000007")).intValue();

    }

    private BigInteger binomial(int large, int small) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < small; k++) {
            ret = ret.multiply(BigInteger.valueOf(large-k))
                    .divide(BigInteger.valueOf(k+1));
        }
        return ret;
    }

}
