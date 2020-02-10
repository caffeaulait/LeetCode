package com.caffeaulait;

public class nowcoder_02 {
    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i< str.toString().length();i++){
            char c = str.charAt(i);
            if (c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
