//package com.dgarg20.ds.strings;
//
///**
// * Created by Deepanshu Garg on 18/06/21.
// */
//public class StringToNumberLC8 {
//    public static void main(String[] args) {
//        StringToNumberLC8 stringToNumberLC8 = new StringToNumberLC8();
//        System.out.println(stringToNumberLC8.myAtoi("abcd  +429 9 hello"));
//    }
//    public int myAtoi(String s) {
//
//        s.trim();
//        boolean isPositive = true;
//        Long ans = 0L;
//        boolean started = false;
//       // int ansStart;
//       // int andEnd = s.length();
//        for(int i =0;i< s.length() ; i++) {
//
//
//            char ch = s.charAt(i);
//            if(started && !(ch >= '0' && ch <= '9' )) {
//                //andEnd = i;
//                break;
//            }
//
//            else if(!started) {
//                if(ch == '-'){
//                    isPositive = false;
//                    started = true;
//                }
//                else if(ch == '+'){
//                    isPositive = true;
//                    started = true;
//                }
//                else if (ch >= '0' && ch <= '9'){
//                    started = true;
//                    //ansStart = i;
//                    ans = Long.parseLong(String.valueOf(s.charAt(i)));
//                }
//            }
//
//            else if(started && (ch >= '0' && ch <= '9' )) {
//                ans = (ans *10) +  Long.parseLong(String.valueOf(s.charAt(i)));
//                if(ans >=  Integer.MAX_VALUE -1) {
//                    //andEnd = i-1;
//                    break;
//                }
//            }
//        }
//
//        if(isPositive && ans <= Integer.MAX_VALUE -1)
//            return ans.intValue();
//
//
//        else if(isPositive && ans > Integer.MAX_VALUE -1)
//            return Integer.MAX_VALUE;
//
//        else if(!isPositive && ans <= Integer.MAX_VALUE)
//           return 0 - ans.intValue();
//
//        else if (!isPositive && ans > Integer.MAX_VALUE)
//            return -Integer.MAX_VALUE;
//
//    }
//}
