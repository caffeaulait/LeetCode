package com.caffeaulait;

public class _0065_ValidNumber {
    /**
     * Validate if a given string can be interpreted as a decimal number.
     *
     * Some examples:
     * "0" => true
     * " 0.1 " => true
     * "abc" => false
     * "1 a" => false
     * "2e10" => true
     * " -90e3   " => true
     * " 1e" => false
     * "e3" => false
     * " 6e-1" => true
     * " 99e2.5 " => false
     * "53.5e93" => true
     * " --6 " => false
     * "-+3" => false
     * "95a54e53" => false
     *
     * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:
     *
     * Numbers 0-9
     * Exponent - "e"
     * Positive/negative sign - "+"/"-"
     * Decimal point - "."
     * Of course, the context of these characters also matters in the input.
     */

    public boolean isNumber(String s) {
        int state = 0;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (state == 0) {
                    state = 1;
                } else if (state == 4) {
                    state = 6;
                } else {
                    return false;
                }
            }
            else if (c >= '0' && c <= '9') {
                switch (state) {
                    case 0:
                    case 1:
                    case 2:
                        state = 2;
                        break;
                    case 3:
                        state = 3;
                        break;
                    case 4:
                    case 5:
                    case 6:
                        state = 5;
                        break;
                    case 7:
                    case 8:
                        state = 8;
                        break;
                    default:
                        return false;
                }
            }
            else if (c == '.') {
                switch (state) {
                    case 0:
                    case 1:
                        state = 7;
                        break;
                    case 2:
                        state = 3;
                        break;
                    default:
                        return false;
                }
            }
            else if (c=='e') {
                switch (state) {
                    case 2:
                    case 3:
                    case 8:
                        state = 4;
                        break;
                    default:
                        return false;
                }
            }
            else {
                return false;
            }
        }
        return state == 2 || state == 3 || state == 5 || state == 8;
    }

    /*
    *   S0   +/-    S1
    *   S0   digit  S2
    *   S0   .      S7
    *   S1   digit  S2
    *   S1   .      S7
    *   S2   digit  S2
    *   S2   .      S3
    *   S2   e      S4
    *   S3   digit  S3
    *   S3   e      S4
    *   S4   digit  S5
    *   S4   +/-    S6
    *   S5   digit  S5
    *   S6   digit  S5
    *   S7   digit  S8
    *   S8   digit  S8
    *   S8   e      S4
    *
    *   reference from https://leetcode.wang/leetCode-65-Valid-Number.html
    * */

}
