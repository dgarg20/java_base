package com.dgarg20.ds.dp.LCS.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Deepanshu Garg on 02/08/20.
 */
public class LongestCommonSubSequenceBottomUp {
    private int memArray[][];

    public LongestCommonSubSequenceBottomUp(int m, int n) {
        memArray = new int [m+1][n+1];
        for(int i =0; i<= m ; i++) {
            for(int j =0; j <=n; j++) {
                this.memArray[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
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
        LongestCommonSubSequenceBottomUp longestCommonSubSequenceBottomUp = new LongestCommonSubSequenceBottomUp(s1.length(), s2.length());
        System.out.println(longestCommonSubSequenceBottomUp.findLongestCommonSubsequence(s1, s2, s1.length(), s2.length()));
    }

    public int findLongestCommonSubsequence(String s1, String s2, int lengthString1, int lengthString2) {
        if (lengthString1 == 0 || lengthString2 == 0) {
            return 0;
        }
        else if(this.memArray[lengthString1][lengthString2] != -1)
            return this.memArray[lengthString1][lengthString2];
        else if (s1.charAt(lengthString1 - 1) == s2.charAt(lengthString2 - 1)) {
            return this.memArray[lengthString1][lengthString2] = 1 + findLongestCommonSubsequence(s1, s2, lengthString1 - 1, lengthString2 - 1);
        } else
            return this.memArray[lengthString1][lengthString2] = Math.max(findLongestCommonSubsequence(s1, s2, lengthString1 - 1, lengthString2), findLongestCommonSubsequence(s1, s2, lengthString1, lengthString2 - 1));
    }

    @Test
    public void test1() {
        String s1 = "abcdgh";
        String s2 = "abedfha";
        int actualOutput = 4;
        LongestCommonSubSequenceBottomUp longestCommonSubSequenceBottomUp = new LongestCommonSubSequenceBottomUp(s1.length(), s2.length());
        Assertions.assertEquals(longestCommonSubSequenceBottomUp.findLongestCommonSubsequence(s1, s2, s1.length(), s2.length()), actualOutput);
    }

    @Test
    public void test2() {
        String s1 = "axyt";
        String s2 = "ayzx";
        int actualOutput = 2;
        LongestCommonSubSequenceBottomUp longestCommonSubSequenceBottomUp = new LongestCommonSubSequenceBottomUp(s1.length(), s2.length());
        Assertions.assertEquals(longestCommonSubSequenceBottomUp.findLongestCommonSubsequence(s1, s2, s1.length(), s2.length()), actualOutput);
    }
}
