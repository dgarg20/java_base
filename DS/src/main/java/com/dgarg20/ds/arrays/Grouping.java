package com.dgarg20.ds.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Deepanshu Garg on 28/10/20.
 */
public class Grouping {
    public static void main(String[] args) {
        int n = 4;
        int[][] arr = {{1, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}};
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 || arr[j][i] == 1) {
                    if (ans[i] < ans[j]) {
                        ans[j] = ans[i];
                    } else {
                        ans[j] = ans[i];
                    }
                }
            }
        }
        Set<Integer> answer = new HashSet<Integer>();

        for (int i : ans) {
            answer.add((Integer) i);
        }

        System.out.println(answer.size());
    }

}

