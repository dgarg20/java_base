package com.dgarg20.java_base.movie_booking;

import java.util.Scanner;

/**
 * Created by Deepanshu Garg on 30/01/21.
 */
public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("please enter the choice");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: {
                    System.out.println(ch);
                    break;
                }
                case 2: {
                    System.out.println(ch);
                    break;
                }
                case 3: {
                    System.out.println(ch);
                    break;
                }
                case 4: {
                    System.out.println(ch);
                    break;
                }
                case 5: {
                    System.out.println(ch);
                    break;
                }
                default: {
                    System.out.println("Wrong choice entered. Please enter the valid choice");
                }
            }
        }
    }
}
