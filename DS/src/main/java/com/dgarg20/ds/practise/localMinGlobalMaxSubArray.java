package com.dgarg20.ds.practise;

/**
 * Created by Deepanshu Garg on 31/05/21.
 */
public class localMinGlobalMaxSubArray {
//    int maxMinInSegments(int[] arr, int m) {
//
//        int localMin1 = arr[0];
//        for(int i =0; i<m; i++){
//            localMin1 = Math.min(localMin1, arr[i]);
//        }
//        int globalMax;
//        globalMax = localMin1;
//        for(int i =1 ; i< arr.length - m +1; i++){
//               globalMax = Math.max(findMinInSubArray(arr,i, m), globalMax);
//            //System.out.println("globalmaX" + globalMax);
//        }
//
//        return globalMax;
//
//    }
    int findMinInSubArray(int arr[], int start, int m){
        int localMin1 = arr[start];

        for(int i =start; i<m+start; i++){
            localMin1 = Math.min(localMin1, arr[i]);
        }

        //System.out.println("localmin" + localMin1);
        return localMin1;
    }

    public static void main(String[] args) {
        localMinGlobalMaxSubArray localMinGlobalMaxSubArray = new localMinGlobalMaxSubArray();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(localMinGlobalMaxSubArray.maxMinInSegments(arr, 1));
    }




    int maxMinInSegments(int[] arr, int m) {

        int localMin1 = arr[0];
        for(int i =0; i<m; i++){
            localMin1 = Math.min(localMin1, arr[i]);
        }
        int globalMax;
        globalMax = localMin1;
        for(int i =1 ; i< arr.length - m +1; i++){
            if(arr[i+m] < localMin1) {
                localMin1 = arr[i];
                globalMax = Math.max(globalMax, localMin1);
            }
            else if(arr[i-1] == localMin1){
                globalMax = Math.max(findMinInSubArray(arr,i, m), globalMax);
            }
        }

        return globalMax;

    }
}
