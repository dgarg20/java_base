package com.dgarg20.splitwise.repositories;

import com.dgarg20.splitwise.exceptions.InvalidUserException;
import com.dgarg20.splitwise.models.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Deepanshu Garg on 03/09/21.
 */
public class ExpenseRepository {
    private static ExpenseRepository expenseRepository;
    private Map<User, Map<User, Float>> usedOwesTo;


    private ExpenseRepository(){
        this.usedOwesTo = new HashMap<>();
    }

    public static ExpenseRepository getInstance(){
        if(expenseRepository == null){
            synchronized (ExpenseRepository.class){
                expenseRepository = new ExpenseRepository();
            }
        }
        return expenseRepository;
    }

    public Map<User, Float> getUser(String userId) throws RuntimeException{
        if(usedOwesTo.containsKey(UserRepository.getInstance().getUser(userId)))
            return usedOwesTo.get(UserRepository.getInstance().getUser(userId));
        else
            return new HashMap<>();
    }

    public void addExpense(User spendingUser, User owingUser, float amount){

    }
}
