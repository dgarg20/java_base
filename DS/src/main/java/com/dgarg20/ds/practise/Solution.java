package com.dgarg20.ds.practise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Deepanshu Garg on 16/03/21.
 */

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");


        String s1 = "Alexander";
        String s2 = "Elisabeth";

        Set<Character> s1Set= new HashSet<Character>();
        Set<Character> s2Set = new HashSet<Character>();
        for(int i=0 ; i< s1.length(); i++) {
            s1Set.add(s1.charAt(i));
        }

        for(int i =0 ; i< s2.length(); i++){
            s2Set.add(s2.charAt(i));
        }

        String a1 = "";
        for(char ch: s1Set){
            a1 = a1 + ch;
        }
        String a2 = "";
        for(char ch: s2Set){
            a2 = a2 + ch;
        }

        String s1New = "";
        String s2New = "";
        for(int i =0; i< a1.length(); i++){
            if(!s2Set.contains(a1.charAt(i))) {
                s1New = s1New + a1.charAt(i);
            }
        }

        for(int i =0; i< a2.length(); i++){
            if(!s1Set.contains(a2.charAt(i))) {
                s2New = s2New + a2.charAt(i);
            }
        }


        String flames = "FLAMES";
        System.out.println(s1New);
        System.out.println(s2New);
        System.out.println(flames.charAt(((s1New.length() + s2New.length()) % flames.length()) -1));

    }
}
