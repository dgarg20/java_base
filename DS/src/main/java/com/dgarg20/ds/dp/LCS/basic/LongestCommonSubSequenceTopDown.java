package com.dgarg20.ds.dp.LCS.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;

/**
 * Created by Deepanshu Garg on 02/08/20.
 */
public class LongestCommonSubSequenceTopDown {
    public static void main(String[] args)throws Exception {
        LongestCommonSubSequenceTopDown longestCommonSubSequenceTopDown = new LongestCommonSubSequenceTopDown();
        String s1;
        String s2;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bis = new BufferedReader(isr);
        DataInputStream dis = new DataInputStream(System.in);
        System.out.println("Enter String one");
        s1 =bis.readLine();
        System.out.println("Enter String two");
        s2 = bis.readLine();
        System.out.println(longestCommonSubSequenceTopDown.findLongestCommonSubsequence(s1,s2, s1.length(), s2.length()));
    }

    public int findLongestCommonSubsequence(String s1, String s2, int lengthString1, int lengthString2) {
        int arr[][] = new int[lengthString1][lengthString2];
        if(s1.charAt(lengthString1-1) == s2.charAt(lengthString2-1))
            arr[lengthString1-1][lengthString2-1] = 1;
        else
            arr[lengthString1-1][lengthString2-1] = 1;

        for(int x = lengthString2; x >= 0; x--) {
            for(int y = lengthString2; y >= 0; y--) {

            }
        }
        return 0;
    }

    @Test
    public void test1() {
        LongestCommonSubSequenceTopDown longestCommonSubSequenceTopDown = new LongestCommonSubSequenceTopDown();
        String s1 = "abcdgh";
        String s2 = "abedfha";
        int actualOutput = 4;
        Assertions.assertEquals(longestCommonSubSequenceTopDown.findLongestCommonSubsequence(s1,s2,s1.length(), s2.length()), actualOutput);
    }
}
