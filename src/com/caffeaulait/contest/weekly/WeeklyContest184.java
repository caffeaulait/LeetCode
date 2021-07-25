package com.caffeaulait.contest.weekly;

import java.util.*;

public class WeeklyContest184 {

    public List<String> stringMatching(String[] words) {
        Set<String> set = new HashSet<>();
        Arrays.sort(words, (a,b) -> (a.length() - b.length()));
        for (int i = 0; i< words.length- 1; i++){
            for (int j = i+1; j < words.length; j++){
                if (words[j].contains(words[i])) set.add(words[i]);
            }
        }
        return new ArrayList<>(set);
    }

    public int[] processQueries(int[] queries, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i<=m; i++){
            list.add(i);
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length;i++){
            int num = queries[i];
            int index = list.indexOf(num);
            result[i] = index;
            list.remove(index);
            list.add(0, num);
        }
        return result;
    }

    public String entityParser(String text) {
        text = text.replaceAll("&quot;", "\"");
        text = text.replaceAll("&apos;", "'");
        text = text.replaceAll("&amp;", "&");
        text = text.replaceAll("&gt;",">");
        text = text.replaceAll("&lt;", "<");
        text = text.replaceAll("&frasl;", "/");
        return text;
    }

    public int numOfWays(int n) {
        long twoColor = 6;
        long threeColor = 6;
        long modulo = (long) Math.pow(10, 9) + 7;
        for (int i = 2; i <=n; i++){
            long temp = threeColor;
            threeColor = 2 * (threeColor + twoColor) % modulo;
            twoColor = 2 * temp + 3*twoColor % modulo;
        }
        long result = (threeColor + twoColor) % modulo;
        return (int) result;
    }

    /**
     *        B       B
     *        A       C               +2 (2 colors)
     *        B       B
     *   A
     *   B
     *   C
     *        C     B
     *        A     C                  +2  (3colors)
     *        B     A
     *
     *
     *          B   C   B
     *          A   A   C                +3 (2 colors)
     *          B   C   B
     *
     *  A
     *  B
     *  A
     *
     *          B   C
     *          A   A                   +2 (3 colors)
     *          C   B
     */
}
