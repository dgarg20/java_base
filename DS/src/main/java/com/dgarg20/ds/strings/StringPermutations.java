package com.dgarg20.ds.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Deepanshu Garg on 19/07/21.
 */
public class StringPermutations {
    public static void main(String[] args) {
        String s = "abcdd";
        Set<String> allStrings = new HashSet<>();
        StringPermutations sp = new StringPermutations();
        sp.permute(s,0,allStrings);
        System.out.println("Total Strings " + allStrings.size());
        for (String x: allStrings) {
            System.out.println(x);
        }

    }


    public void permute(String str, int fixed, Set<String> allStrings){
        for(int i= fixed; i< str.length(); i++){
            String s = swap(str, fixed, i );
            System.out.println(s);
            allStrings.add(s);
            permute(s, fixed+1, allStrings);
        }
    }

    public static String swap(String str, int i, int j)
    {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
