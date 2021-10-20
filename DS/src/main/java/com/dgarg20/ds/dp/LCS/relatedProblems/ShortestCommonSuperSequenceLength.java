package com.dgarg20.ds.dp.LCS.relatedProblems;

import com.dgarg20.ds.dp.LCS.basic.LongestCommonSubSequenceTopDown;
import com.dgarg20.ds.dp.LCS.basic.LongestCommonSubsequenceRecursive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by Deepanshu Garg on 16/08/20.
 */
public class ShortestCommonSuperSequenceLength {
    public static void main(String[] args) {

    }

    public int superSequence(String s1, String s2) {
    return 0;
    }


    @Test
    public void commonSubsequenceTest1() {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        /**
         *Shortest Common Subsequence =  AGGXTXAYB
         * LCS - GTAB
         *
         */
        ShortestCommonSuperSequenceLength shortestCommonSuperSequenceLength = new ShortestCommonSuperSequenceLength();
        LongestCommonSubsequenceRecursive longestCommonSubsequenceRecursive = new LongestCommonSubsequenceRecursive();
        int a = s1.length() + s2.length() - longestCommonSubsequenceRecursive.findLongestCommonSubsequence(s1,s2, s1.length(), s2.length());
        Assertions.assertEquals(9, a);
    }
}
