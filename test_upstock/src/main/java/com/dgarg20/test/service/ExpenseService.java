package com.dgarg20.test.service;

import com.dgarg20.test.model.Command;
import com.dgarg20.test.model.ExpenseSplitType;
import com.dgarg20.test.model.User;
import com.dgarg20.test.model.UserShare;

import java.util.LinkedList;
import java.util.List;


public class ExpenseService {
    public List<UserShare> getUsersShare(Command command, ExpenseSplitType expenseSplitType, int peopleCount, User spendingUser){
        List<UserShare> userShares= new LinkedList<>();
        if(expenseSplitType == ExpenseSplitType.EQUAL){

        }
        else if(expenseSplitType == ExpenseSplitType.PERCENTAGE){

        }
        else if(expenseSplitType == ExpenseSplitType.EXACT){
            for(int i = 1; i<=peopleCount; i++){
                UserShare userShare = new UserShare(command.getParams().get(2+i), Float.parseFloat(command.getParams().get(2+peopleCount+1+i)));
            }
        }
        return userShares;
    }
}
