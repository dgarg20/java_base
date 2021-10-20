package com.dgarg20.test1.models;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Deepanshu Garg on 01/02/21.
 */

@Data
public abstract class User {
    private String name;
    private Queue<Ticket> userTickets;

    public User(String name) {
        this.name = name;
        this.userTickets = new LinkedList<>();
    }

    public void resolve(){

    }

}
