package com.dgarg20.ds.companies;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 * AGODA
 */

// Given that we are getting a stream of parent child relationship, where first element is parent and secind is child. We need to find the entries with 0 and 2 parents.
// 1   3
// \ / \
//  2   5
// /    / \
// 4    6   7
// \ /
//  8
//
//

// (1,2)
// (3,2)
// (3,5)
// (2,4)
// (5,6)
// (5,7)
// (6,8)
// (4,8)
// Entries with 0 parent - 1,3
// Entries with 2 parents - 2,8

public class ParentChildRelationShip {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
//        strings.add("This pad is running Java " + Runtime.version().feature());


        List<Pair<Integer, Integer>> relationship = new LinkedList();
        relationship.add(new Pair(1,2));
        relationship.add(new Pair(3,2));
        relationship.add(new Pair(3,5));
        relationship.add(new Pair(2,4));
        relationship.add(new Pair(5,6));
        relationship.add(new Pair(5,7));
        relationship.add(new Pair(6,8));
        relationship.add(new Pair(4,8));


        Map<Integer, Integer> parentCountMap = new HashMap();

        for(Pair pair: relationship){
            if(!parentCountMap.containsKey(pair.getKey()))
                parentCountMap.put( (Integer)pair.getKey(), 0);
            if(!parentCountMap.containsKey(pair.getValue()))
                parentCountMap.put((Integer) pair.getValue(), 0);


            parentCountMap.put((Integer) pair.getValue(), parentCountMap.get(pair.getValue()) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: parentCountMap.entrySet()){
            if(entry.getValue() == 0 || entry.getValue() == 2)
                System.out.println(entry.getKey() + " has " + entry.getValue() + "parents ");
        }
    }


    static class Pair<T1, T2> {
        private T1 a;
        private T2 b;

        public Pair(T1 a , T2 b){
            this.a = a;
            this.b = b;
        }

        public T1 getKey(){
            return a;
        }

        public T2 getValue(){
            return b;
        }
    }
}
