package com.dgarg20.ds.practise;

import java.util.stream.IntStream;

/**
 * Created by Deepanshu Garg on 30/05/21.
 */
public class SolveMicro {
        public boolean findIfProper(int[] A) {
            boolean isProper = true;
            if(A[0]> A[1]){
                for(int i =1; i<A.length-1; i++) {
                    if(i%2==0){
                        if(!(A[i-1] < A[i] && A[i+1] < A[i])){
                            isProper = false;
                            break;
                        }

                    }
                    if(i%2!=0){
                        if(!(A[i-1]  > A[i] && A[i+1] > A[i])){
                            isProper = false;
                            break;
                        }

                    }
                }
            }
            if(A[0] < A[1]){
                for(int i =1; i<A.length-1; i++) {
                    if(i%2==0){
                        if(!(A[i-1] > A[i] && A[i+1] > A[i])){
                            isProper = false;
                            break;
                        }

                    }
                    if(i%2!=0){
                        if(!(A[i-1]  < A[i] && A[i+1] < A[i])){
                            isProper = false;
                            break;
                        }

                    }
                }
            }
            return isProper;
        }

        public int solution(int A[]){
            if(findIfProper(A))
                return 0;

            int count = 0;

            for(int i =0; i <A.length; i++){
                if(findIfProper(findSubArrayByRemovingGivenIndex(A, i))){
                    count ++;
                }
            }
            if(count == 0)
                return -1;
            else
                return count;

        }

        public int[] findSubArrayByRemovingGivenIndex(int arr[], int index){
          return   IntStream.range(0, arr.length)
                    .filter(i -> i != index)
                    .map(i -> arr[i])
                    .toArray();
        }


    public static void main(String[] args) {
        SolveMicro solveMicro = new SolveMicro();
        int arr[] = {3,4,5,3,7};
        solveMicro.solution(arr);
    }
}
