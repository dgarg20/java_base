package com.dgarg20.java_base.dtos;

import lombok.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Deepanshu Garg on 16/12/20.
 */

@Getter
@Setter
@AllArgsConstructor

public class Group {
    private String name;
    private int id;
    private List<User> users;
    private User adminUser;

    public Group(){
        users= new LinkedList<>();
    }

    public void addUsers(List<User> user){
        this.users.addAll(user);
    }
}
