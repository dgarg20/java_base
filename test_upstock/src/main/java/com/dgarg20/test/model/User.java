package com.dgarg20.test.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;






@Getter
@Setter
public class User {
    private String name;
    private String id;

    private  List<UserShare> owedTo;
    private  List<UserShare> owedFrom;

    public User(String id, String name){
        this.id = id;
        this.name = name;
        owedTo = new ArrayList<>();
        owedFrom = new ArrayList<>();
    }

}
