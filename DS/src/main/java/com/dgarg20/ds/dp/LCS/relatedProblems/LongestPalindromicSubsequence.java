package com.dgarg20.ds.dp.LCS.relatedProblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by Deepanshu Garg on 16/08/20.
 */




public class LongestPalindromicSubsequence {

    public static void main(String[] args) {

    }

    public int findLongestPalindromicSubsequence(String s1) {
        return 0;
    }

    @Test
    public void testCase1() {
      String s1 = "agbcba";
      LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();
        Assertions.assertEquals(5, longestPalindromicSubsequence.findLongestPalindromicSubsequence(s1));
    }
}
