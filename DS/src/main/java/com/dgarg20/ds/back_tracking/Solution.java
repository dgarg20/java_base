package com.dgarg20.ds.back_tracking;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public String solution(String riddle) {
        char[] chars = riddle.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                int j = 97;
                while (chars[i] == '?') {
                    char c = (char) j;
                    if (riddle.length() == 1) {
                        chars[i] = 'a';
                    }else if( i-1 >=0 && i+1 <= chars.length-1){
                        if (chars[i - 1] != c && chars[i + 1] != c) {
                            chars[i] = c;
                        }
                    }
                    else if (i - 1 < 0 && chars[i + 1] != c) {
                            chars[i] = c;

                    } else if (i + 1 == chars.length && chars[i - 1] != c){
                            chars[i] = c;
                    }
                        j++;
                }
            }
        }
        return String.valueOf(chars);
        }
}

