//package com.dgarg20.ds.practise;
//
///**
// * Created by Deepanshu Garg on 14/03/21.
// */
//
//
//// Given a 2D array of integers, you have to pick exactly one element from each row.
//// You cannot pick elements from same column for any adjacent row.
//// Maximize the sum of integers picked.
//
//// 1 base idx
//// 1  2  3
//// 4  5  2
//// 6  10 7
//// Ans 17
//
////arr[i][j] => max value you get when you pick elem[i][j]
////        compute values of arr[i + 1][1] ... arr[i + 1][M] using arr[i][1...M]
//
//
////        1 2, 3
////
////        7, 8, 4
////
////        14, 17, 15
//
//public class MaxSumIf1ElementFromEachRow {
//    public static void main(String[] args) {
//
//
//        for (int i = 0; i < m; i++) {
//            int max = Integer.Min_Value
//            int max2 = Integer.Min_Value;
//
//        }
//
//
//        for (int i = 1; i < m; i++) {
//
//            for (int j = 0; j < n; j++) {
//                if (j == lastMaxIndex) {
//                    arr[i][j] += max2;
//                } else {
//                    arr[i][j] += max;
//                }
//
//
////        Finding Max in corresponding ith Row
//                max = Integer.Min_Value
//                max2 = Integer.Min_Value;
//                for (int j = 0; j < n; j++) {
//                    if (arr[i][j] > max) {
//                        max2 = max;
//                        max_index = j
//                        max = arr[i][j]
//                    }
//
//                }
//                system.out.print(max)
//
//            }
//
//
//        }
//    }
//}
//
//
//
//
