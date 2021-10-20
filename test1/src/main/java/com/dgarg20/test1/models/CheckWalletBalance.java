package com.dgarg20.test1.models;

import com.dgarg20.test1.repository.DriverClass;

/**
 * Created by Deepanshu Garg on 01/02/21.
 */
public class CheckWalletBalance extends Ticket {
    private DriverClass dc = DriverClass.getInstance();

    public CheckWalletBalance(String description) {
        super(description, TicketType.CHECK_WALLET_BALANCE);

    }

    public void createTicket(String message){

    }

    public void resolveTicket(){
        this.setStatus(Status.CLOSED);
        this.setResolvedBy(null);
        this.setResolvedBy(null);
    }
}
