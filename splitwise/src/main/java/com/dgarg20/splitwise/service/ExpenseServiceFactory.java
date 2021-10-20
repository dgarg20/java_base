package com.dgarg20.splitwise.service;

import com.dgarg20.splitwise.exceptions.InvalidCommandException;
import com.dgarg20.splitwise.models.ExpenseType;

import java.util.Map;

/**
 * Created by Deepanshu Garg on 03/09/21.
 */
public class ExpenseServiceFactory {
    private Map<ExpenseType, ExpenseService> factoryMap;

    public ExpenseServiceFactory(){
        factoryMap.put(ExpenseType.EQUAL, new EqualExpense());
        factoryMap.put(ExpenseType.EXACT, new ExactExpense());
    }

    public ExpenseService getExpenseService(ExpenseType expenseType)throws RuntimeException{
        if(factoryMap.containsKey(expenseType))
            return factoryMap.get(expenseType);
        else
            throw new InvalidCommandException();
    }
}
