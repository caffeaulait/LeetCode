package com.caffeaulait;

import java.util.ArrayList;
import java.util.List;

public class WeeklyContest207 {
    /**
     * q1   pass
     * q2   fail
     * q3   fail
     * q4   fail
     */
    public String reorderSpaces(String text) {
        int spaceCount = 0;
        boolean lastSpace = false;
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for(char c : text.toCharArray()) {
            if (c != ' ') {
                if (lastSpace) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }else {

                }
                sb.append(c);
                lastSpace = false;
            } else {
                spaceCount++;
                lastSpace = true;
            }
        }
        if (sb.length()!=0) list.add(sb.toString());
        System.out.println(list);
        if (allSpaces(list.get(0))) list.remove(0);
        if (list.size() == 1) {
            StringBuilder spaces = new StringBuilder();
            for (int i = 0; i < spaceCount; i++) {
                spaces.append(" ");
            }
            return list.get(0) + spaces;
        }else{
            int slots = list.size()-1;
            int spaceEach = spaceCount / slots;
            int remaining = spaceCount % slots;
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < list.size();i++){
                res.append(list.get(i));
                if (i!=list.size()-1 ){
                    for (int j = 0; j < spaceEach; j++) res.append(' ');
                }
            }
            for (int i = 0; i < remaining; i++) res.append(' ');
            return res.toString();
        }
    }

    public boolean allSpaces(String s){
        for (char c : s.toCharArray()) {
            if (c != ' ') return false;
        }
        return true;
    }
}
