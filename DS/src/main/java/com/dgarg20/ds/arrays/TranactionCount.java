package com.dgarg20.ds.arrays;

import java.util.*;

/**
 * Created by Deepanshu Garg on 28/10/20.
 */
public class TranactionCount {

    public static void main(String[] args) {

    }
    public String[] solve(List<String>logs, int n, int thresh){
        Map<Integer, Integer> mat = new HashMap<Integer, Integer>();
        for(int i =0; i<n; i++) {
            String[] arr = logs.get(i).split("  ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            if(a !=b) {
                if(!mat.containsKey(a)){
                    mat.put(a, 1);
                }
                else {
                    mat.put(a, mat.get(a)+1);
                }
            }
            else {
                if (!mat.containsKey(a)) {
                    mat.put(a, 1);
                } else {
                    mat.put(a, mat.get(a) + 1);
                }
                if (!mat.containsKey(b)) {
                    mat.put(b, 1);
                } else {
                    mat.put(b, mat.get(b) + 1);
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry: mat.entrySet()) {
            if(entry.getValue() > thresh){
                mat.remove(thresh);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        ans.addAll(mat.values());
        Collections.sort(ans);
        String[] finalAnswer = new String[ans.size()];
        int a =0;
        for(Integer i: ans) {
            finalAnswer[a] = i.toString();
        }
        return finalAnswer;
    }
}
