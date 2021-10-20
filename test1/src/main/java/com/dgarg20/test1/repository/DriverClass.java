package com.dgarg20.test1.repository;

import com.dgarg20.test1.models.*;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.jetty.util.DateCache;

import java.util.*;

/**
 * Created by Deepanshu Garg on 30/01/21.
 */

public class DriverClass {
    private int nextId = 0;
    private static DriverClass driverClass;

    Queue<Ticket> unassignedTickets;

    Map<Integer, Ticket> ticketMap;
    List<User> users;



    private DriverClass(){
        unassignedTickets = new LinkedList<>();
        User emp1 = new Employee("Sam");
        User emp2 = new Employee("Tom");
        User supperVisor = new Supervisor("Harry");
        users = Arrays.asList(emp1, emp2, supperVisor);

        ticketMap = new HashMap<>();
    }

    public static DriverClass getInstance(){
        if (driverClass ==null) {
            driverClass = new DriverClass();
        }
        return driverClass;
    }


    public Ticket getUnAssignedTicket() throws ServiceException{
        return null;
    }


    public void addTicket(Ticket ticket){
        this.unassignedTickets.add(ticket);
        this.ticketMap.put(ticket.getId(), ticket);
    }

    public void getFirstUnassignedTicket(Ticket ticket){
        this.ticketMap.put(ticket.getId(), ticket);
        this.unassignedTickets.add(ticket);
    }

    public  int getNextTicketId() {
        nextId = nextId + 1;
        return nextId;
    }


    public Ticket getTicketWithId(int id)throws ServiceException {
        if(ticketMap.containsKey(id)) {
            return this.ticketMap.get(id);
        }
        else throw new ServiceException("No Ticket Found");
    }

}
