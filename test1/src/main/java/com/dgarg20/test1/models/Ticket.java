package com.dgarg20.test1.models;

import com.dgarg20.test1.repository.DriverClass;
import lombok.Data;

/**
 * Created by Deepanshu Garg on 01/02/21.
 */


public class Ticket {
    private int id;
    private Status status;
    private String description;
    private String comments;
    private User resolvedBy;
    private User verifiedBy;
    private TicketType ticketType;
    private DriverClass dc;


    public Ticket(String description, TicketType ticketType){
        dc = DriverClass.getInstance();
        this.id = dc.getNextTicketId();
        this.description = description;
        this.status = Status.OPENED;
        this.ticketType = ticketType;
    }

    public int getId() {
        return id;
    }

    public Status getStatus(Status status){
        return this.status;
    }

    public String getComments() {
        return comments;
    }

    public User getResolvedBy() {
        return resolvedBy;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public void setComments(String comments) {
        this.comments = comments;
    }


    public void setVerifiedBy(User verifiedBy) {
        this.verifiedBy = verifiedBy;
    }


    public User getVerifiedBy() {
        return verifiedBy;
    }

    public void setResolvedBy(User resolvedBy) {
        this.resolvedBy = resolvedBy;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public String getDescription() {
        return description;
    }


    public TicketStatusResponse getStatus() {
        return new TicketStatusResponse(id, status.name(), comments, resolvedBy == null ? "Nil": resolvedBy.getName(), verifiedBy== null ? "Nil": verifiedBy.getName());
    }
}
