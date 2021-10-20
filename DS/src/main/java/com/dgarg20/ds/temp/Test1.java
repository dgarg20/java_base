package com.dgarg20.ds.temp;

/**
 * Created by Deepanshu Garg on 02/08/21.
 */
public class Test1 {
    int countOfFiveUtil(int arr[],int low,int high) {
        if(low > high) {
            return 0;
        }
        int count = 0;

        int mid = low + (high - low)/2;
        if(arr[mid] == 5) {
            count += 1;
            count += ( countOfFiveUtil(arr,low,mid - 1) + countOfFiveUtil(arr,mid + 1,high) );
            return count;
        }
        else if(arr[mid] > 5){
            return countOfFiveUtil(arr,low,mid - 1);
        }
        else {
            return countOfFiveUtil(arr,mid + 1,high);
        }
    }
    int countOfFive(int[] arr,int n) {
        if(n == 0) {
            return 0;
        }
        return countOfFiveUtil(arr,0,n-1);
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int[] arr = {5,5,5,5,5,5,5,5,5};
        System.out.println(test1.countOfFive(arr, arr.length));
    }
}
