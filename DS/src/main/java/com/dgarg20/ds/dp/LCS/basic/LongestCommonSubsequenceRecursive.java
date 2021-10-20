package com.dgarg20.ds.dp.LCS.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Deepanshu Garg on 02/08/20.
 */


/**
 * Longest common subsequence is the problem in which we checks that the number of common letters in the two strings
 *
 * Base condition  -- Smallest input possible
 *
 *
 * choice
 * if same evaluate for add one and evaluate for the left over string
 *
 * If not same
 * Max( drop one last character for the string 1 and same string 2, drop one last character for the string 2 and same string 1)
 * Recurssion
 *
 * Top Down
 *
 */
public class LongestCommonSubsequenceRecursive {
    public static void main(String[] args)throws Exception {
        LongestCommonSubsequenceRecursive longestCommonSubsequenceRecursive = new LongestCommonSubsequenceRecursive();
        String s1;
        String s2;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bis = new BufferedReader(isr);
        DataInputStream dis = new DataInputStream(System.in);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String one");
        s1 = sc.nextLine();
        System.out.println("Enter String two");
        s2 = sc.nextLine();
        System.out.println(longestCommonSubsequenceRecursive.findLongestCommonSubsequence(s1,s2, s1.length(), s2.length()));
    }

    public int findLongestCommonSubsequence(String s1, String s2, int lengthString1, int lengthString2) {
        if (lengthString1 == 0 || lengthString2 == 0) {
            return 0;
        } else if (s1.charAt(lengthString1-1) == s2.charAt(lengthString2-1)) {
            return 1 + findLongestCommonSubsequence(s1, s2, lengthString1-1, lengthString2-1);
        }
        else
            return Math.max(findLongestCommonSubsequence(s1, s2, lengthString1-1, lengthString2), findLongestCommonSubsequence(s1, s2, lengthString1, lengthString2-1));
    }

    @Test
    public void test1() {
        LongestCommonSubsequenceRecursive longestCommonSubsequenceRecursive = new LongestCommonSubsequenceRecursive();
        String s1 = "abcdgh";
        String s2 = "abedfha";
        int actualOutput = 4;
        Assertions.assertEquals(longestCommonSubsequenceRecursive.findLongestCommonSubsequence(s1,s2,s1.length(), s2.length()), actualOutput);
    }

    @Test
    public void test2() {
        LongestCommonSubsequenceRecursive longestCommonSubsequenceRecursive = new LongestCommonSubsequenceRecursive();
        String s1 = "axyt";
        String s2 = "ayzx";
        int actualOutput = 2;
        Assertions.assertEquals(longestCommonSubsequenceRecursive.findLongestCommonSubsequence(s1,s2,s1.length(), s2.length()), actualOutput);
    }
}


