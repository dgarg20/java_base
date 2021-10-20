package com.dgarg20.splitwise.service;

import com.dgarg20.splitwise.models.Expense;
import com.dgarg20.splitwise.repositories.ExpenseRepository;

/**
 * Created by Deepanshu Garg on 03/09/21.
 */
public class ExactExpense implements ExpenseService {
    public void addExpense(Expense expense) {
        expense.getUserShareList().stream()
                .forEach(x ->
                        ExpenseRepository.getInstance().addExpense(expense.getSpendingUser(), x.getUser(), x.getShare()));
    }
}
