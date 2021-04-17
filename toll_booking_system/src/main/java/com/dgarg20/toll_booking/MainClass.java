package com.dgarg20.toll_booking;

import com.dgarg20.test1.models.PassType;
import com.dgarg20.test1.models.ServiceException;
import com.dgarg20.test1.models.VehicleType;
import com.dgarg20.test1.services.TollBoothService;
import com.dgarg20.test1.services.TollService;

import java.util.Scanner;

/**
 * Created by Deepanshu Garg on 30/01/21.
 */
public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TollBoothService tollBoothService = new TollBoothService();
        TollService tollService = new TollService();

        while (true) {
            System.out.println("please enter 1 for summary");
            System.out.println("please enter 2 if car at toll");
            String inp;
            int ch = sc.nextInt();
            switch (ch) {
                case 1: {
                    System.out.println("please enter toll Id for summary");
                    try{
                        tollService.tollSummary(sc.next().trim());
                    }catch (ServiceException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 2: {
                    System.out.println("please Enter tollId boothId vehicleNo");
                    try{
                        String input = sc.nextLine();
                        String arr[] = input.split(" " );
                        if(tollService.AllowedToPass(arr[0], arr[2])) {
                            System.out.println("PASS");
                        }
                        else {
                            System.out.println("please Enter  vehicleType Passtype");
                            String input2 = sc.nextLine();
                            String arr2[] = input2.split(" " );
                            PassType passType = PassType.valueOf(arr2[1]);
                            VehicleType  vehicleType = VehicleType.valueOf(arr2[0]);
                            tollBoothService.puchaseToll(arr[2], arr[0], arr[1], vehicleType, passType);
                            System.out.println("PASS");
                        }
                        tollService.AllowedToPass(arr[0], arr[2]);
                        tollService.tollSummary(sc.next().trim());
                    }catch (ServiceException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                }

                default: {
                    System.out.println("Wrong choice entered. Please enter the valid choice");
                }
            }
        }
    }
}
