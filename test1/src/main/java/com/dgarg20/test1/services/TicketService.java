package com.dgarg20.test1.services;

import com.dgarg20.test1.models.*;
import com.dgarg20.test1.repository.DriverClass;

/**
 * Created by Deepanshu Garg on 01/02/21.
 */
public class TicketService {
    DriverClass dc;

    public TicketService() {
        dc = DriverClass.getInstance();
    }
    public int createTicket(String ticketCmd, String message)throws ServiceException {
        TicketType ticketType = null;
        Ticket ticket = null;
        if(ticketCmd.equalsIgnoreCase("others")) {
            ticket = new Others(message);
        }
        else if(ticketCmd.equalsIgnoreCase("change-language")) {
            ticket = new ChangeLanguage("change-language");
        }
        else if(ticketCmd.equalsIgnoreCase("check-wallet-balance")) {
            ticket = new CheckWalletBalance("check-wallet-balance");
        }
        else throw new ServiceException("Not a valid ticket Type");


        dc.addTicket(ticket);

        return ticket.getId();
    }

    public Ticket getTicket(int id)throws Exception {
       return dc.getTicketWithId(id);
    }

}
