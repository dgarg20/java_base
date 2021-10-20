package com.dgarg20.test1;

import com.dgarg20.test1.models.ServiceException;
import com.dgarg20.test1.models.Ticket;
import com.dgarg20.test1.models.TicketStatusResponse;
import com.dgarg20.test1.services.TicketService;

import java.util.Scanner;

/**
 * Created by Deepanshu Garg on 30/01/21.
 */
public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketService ticketService = new TicketService();


        while (true) {
            System.out.println("Enter Command");
            String inp = sc.nextLine();
            String arguments[] = inp.split(" ");

            if(arguments[0].equalsIgnoreCase("create-ticket")) {
                try {
                    System.out.println(ticketService.createTicket(arguments[1], arguments[2]));
                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            else if(arguments[0].equalsIgnoreCase("status")) {
                try {
                    Ticket ticket = ticketService.getTicket(Integer.parseInt(arguments[1]));
                    TicketStatusResponse ticketStatusResponse = ticket.getStatus();
                    System.out.println(ticketStatusResponse.getStatus() + " " +ticketStatusResponse.getResolvedBy());
                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }



//            switch (ch) {
//                case 1: {
//                    System.out.println("");
//                    try{
//
//                    }catch (ServiceException ex){
//                        System.out.println(ex.getMessage());
//                    }
//                    break;
//                }
//                case 2: {
//                    System.out.println("");
//                    try{
//                        String input = sc.nextLine();
//                        String arr[] = input.split(" " );
//
//                    }catch (ServiceException ex){
//                        System.out.println(ex.getMessage());
//                    }
//                    break;
//                }
//
//                default: {
//                    System.out.println("Wrong choice entered. Please enter the valid choice");
//                }
//            }
        }
    }
}
