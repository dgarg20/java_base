package com.dgarg20.ds.temp;

import java.util.*;

/**
 * Created by Deepanshu Garg on 20/06/21.
 */
public class AllSwitchedOnBulbsShining {
    public static void main(String[] args) {
        AllSwitchedOnBulbsShining allSwitchedOnBulbsShining = new AllSwitchedOnBulbsShining();
        int []a = {1,3,4,2,5};  //3
        /*
        int []a = {2,3,4,1,5};   //2
        int []a = {2,1,3,5,4};  //3
        */


        System.out.println(allSwitchedOnBulbsShining.solution(a));
    }

    public int solution(int[] a) {
        SortedSet<Integer> sortedSet = new TreeSet<>();
        int count = 0;
        for(int i =0; i < a.length; i++) {
            sortedSet.add(a[i]);
            if(sortedSet.size() == sortedSet.last())
                count ++;
        }
        return count;
    }
}
