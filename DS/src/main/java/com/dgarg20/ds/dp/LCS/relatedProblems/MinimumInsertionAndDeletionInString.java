package com.dgarg20.ds.dp.LCS.relatedProblems;

/**
 * Created by Deepanshu Garg on 16/08/20.
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Minimum number of insertion And deletion to Convert String a to String b
 * Only Operation Allowed is insertion and deletion
 * If replace also provided becomes Common Problem of edit distance
 * E.g heap - > pea
 * LCS(heap, pea) -> ea
 * letters to be removed from heap - > heap -ea =2
 * letters to be added to ea (pea - ea) -> heap - ea = 1
 */
public class MinimumInsertionAndDeletionInString {

    public static void main(String[] args) {

    }

    public InsertionDeletion findMinInsertionAndDeletion(String a , String b){
        return null;
    }

    @Test
    public void test1(){
        String a  = "heap";
        String b = "pea";
        MinimumInsertionAndDeletionInString minimumInsertionAndDeletionInString = new MinimumInsertionAndDeletionInString();
        Assertions.assertEquals(1, minimumInsertionAndDeletionInString.findMinInsertionAndDeletion(a, b).insertion);
        Assertions.assertEquals(2, minimumInsertionAndDeletionInString.findMinInsertionAndDeletion(a, b).deletion);
    }
}

class InsertionDeletion {
    int insertion;
    int deletion;

    public InsertionDeletion(int a, int b) {
        this.insertion = a;
        this.deletion = b;
    }
}