package com.dgarg20.java_base.service;

import com.dgarg20.java_base.exceptions.TempException;
import com.dgarg20.java_base.requests.AddExpense;
import com.dgarg20.java_base.response.SummaryResponse;

public interface ExpenseService {
    void getExpenseByID(Long Id);
    public SummaryResponse getSummary(int userId);
    public void addExpense(AddExpense addExpense, String user)throws TempException;
}
