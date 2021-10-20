package com.dgarg20.test.repository;


public class ExpenseRepository {
    private static ExpenseRepository expenseRepository = null;

    private ExpenseRepository(){

    }

    private static ExpenseRepository getInstance(){
        if(expenseRepository == null){
            ExpenseRepository expenseRepository = new ExpenseRepository();
        }
        return expenseRepository;
    }
}
