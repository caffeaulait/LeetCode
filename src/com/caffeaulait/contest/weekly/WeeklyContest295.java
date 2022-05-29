package com.caffeaulait.contest.weekly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeeklyContest295 {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        boolean flag = false;
        while (true) {
            for(char c : target.toCharArray()) {
                if (!map.containsKey(c) || map.get(c) == 0) {
                    flag = true;
                    break;
                }else{
                    map.put(c, map.get(c)-1);
                }
            }
            if(flag) {
                break;
            }
            count++;
        }
        return count;
    }


    public String discountPrices(String sentence, int discount) {
        sentence += " ";
        Pattern p = Pattern.compile("\\$\\d+(\\.\\d+)?\\s");
        Matcher m = p.matcher(sentence);
        List<String> res = new ArrayList<>();
        while (m.find()) {
            String price = m.group();
            price = price.substring(1);
            double d = Double.parseDouble(price);
            d = d * (100-discount) / 100.0;
            String ds = "\\$" +String.format("%.2f", d) + " ";
            res.add(ds);
        }
        sentence = sentence.replaceAll("\\$\\d+(\\.\\d+)?\\s", "-");
        int i = 0;
        while (sentence.contains("-")) {
            sentence = sentence.replaceFirst("-", res.get(i));
            i++;
        }
        return sentence.trim();
    }
}
