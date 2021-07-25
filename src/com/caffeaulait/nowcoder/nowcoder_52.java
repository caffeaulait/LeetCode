package com.caffeaulait.nowcoder;

import java.util.LinkedHashMap;
import java.util.Map;

public class nowcoder_52 {
    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
     */
    public int FirstNotRepeatingChar(String str) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i<str.length(); i++){
            Character c = str.charAt(i);
            if (map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }

        for (int i = 0; i <str.length(); i++){
            Character c = str.charAt(i);
            if (map.get(c) == 1){
                return i;
            }
        }
        return -1;
    }
}
