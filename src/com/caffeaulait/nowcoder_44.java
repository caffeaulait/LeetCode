package com.caffeaulait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class nowcoder_44 {
    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
     * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     */

    public ArrayList<String> Permutation(String str) {
        List<String> list = new ArrayList<>();
        if (str!=null && str.length()>0){
            PermuationHelper(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return (ArrayList)list;
    }

    public void PermuationHelper(char[] cs, int i, List<String> list){
        if (i == cs.length-1){
            //遍历完整个长度
            String str = String.valueOf(cs);
            if (!list.contains(str))
                list.add(str);
        }else{
            for (int j = i; j < cs.length;j++){
                swap(cs,i,j);
                PermuationHelper(cs,i+1,list);
                swap(cs,i,j);
            }
        }
    }

    public void swap(char[] cs, int i, int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }


}


