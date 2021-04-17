package com.dgarg20.java_base.driver;

import com.dgarg20.java_base.dtos.Expense;
import com.dgarg20.java_base.dtos.ExpenseSplitter;
import com.dgarg20.java_base.dtos.Group;
import com.dgarg20.java_base.dtos.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Deepanshu Garg on 16/12/20.
 */

@Getter
@Setter
public class DriverClass {
    private List<User> users;
    private List<Group> groups;
    private List<Expense> expenses;
    private List<ExpenseSplitter> expenseSplitters;
    private static DriverClass driverClass;
    private int nextGroupId = 1;
    private int nextExpenseId = 1;

    private DriverClass(){
        User user1 = new User(1, "abc");
        User user2 = new User(2, "deep");
        User user3 = new User(3, "shrey");
        User user4 = new User(4, "anand");
        users = new LinkedList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        groups = new LinkedList<>();
        expenses = new LinkedList<>();
        expenseSplitters = new LinkedList<>();
    }


    public Optional<User> getUserById(int id){
        for(User user: this.users){
            if (user.getId() == id)
                return Optional.of(user);
        }
        return Optional.empty();
    }

    public Optional<User> getUserByName(String id){
        for(User user: this.users){
            if (user.getName().equalsIgnoreCase(id))
                return Optional.of(user);
        }
        return Optional.empty();
    }

    public static DriverClass getInstance(){
        if (driverClass ==null) {
            driverClass = new DriverClass();
        }
        return driverClass;
    }


    public Optional<Group> getGroupByIdAndAdmin(int id, String currentUser){
        for(Group group: this.getGroups()){
            if (group.getId() == id && group.getAdminUser().getName().equalsIgnoreCase(currentUser))
                return Optional.of(group);
        }
        return Optional.empty();
    }


    public Optional<Group> getGroupById(int id){
        for(Group group: this.getGroups()){
            if (group.getId() == id)
                return Optional.of(group);
        }
        return Optional.empty();
    }

    public void addExpenseSplitters(List<ExpenseSplitter> expenseSplitters) {
        this.expenseSplitters.addAll(expenseSplitters);
    }

}
