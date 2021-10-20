package com.dgarg20.test1.models;

import com.dgarg20.test1.repository.DriverClass;

/**
 * Created by Deepanshu Garg on 01/02/21.
 */
public class Others extends Ticket {
    private DriverClass d = DriverClass.getInstance();

    public Others(String description) {
        super(description, TicketType.OTHERS);

    }

    public void createTicket(String message){

    }

    public void resolveTicket(){
        this.setStatus(Status.CLOSED);
        this.setResolvedBy(null);
        this.setResolvedBy(null);
    }
}
