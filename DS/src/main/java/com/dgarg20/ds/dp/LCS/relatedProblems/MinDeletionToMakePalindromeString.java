package com.dgarg20.ds.dp.LCS.relatedProblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by Deepanshu Garg on 16/08/20.
 */

/**
 *
 *
 * Length Of Longest Palindrome subsequence (~LCS) ~ 1/ No Of Deletion
 */
public class MinDeletionToMakePalindromeString {
    public static void main(String[] args) {

    }

    public int findMinDeletionRequired(String s1) {
        return 0;
    }

    @Test
    public void testCase1() {
        String s1 = "agbcba";
        MinDeletionToMakePalindromeString minDeletionToMakePalindromeString = new MinDeletionToMakePalindromeString();
        Assertions.assertEquals(5, minDeletionToMakePalindromeString.findMinDeletionRequired(s1));
    }
}
