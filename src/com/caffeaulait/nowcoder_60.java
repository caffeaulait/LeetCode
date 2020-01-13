package com.caffeaulait;

public class nowcoder_60 {

    public int StrToInt(String str){
        if (str == null || str.length() == 0){
            return 0;
        }

        boolean isNegative = str.charAt(0) == '-';

        int result = 0;

        for (int i = 0; i<str.length();i++){
            char c = str.charAt(i);
            if (i==0 &&(c=='+' || c=='-'))
                continue;
            if (c<'0' || c>'9')
                return 0;
            result = result*10 + (c-'0');
        }
        return isNegative? -result:result;
    }
}
