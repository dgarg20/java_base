package com.dgarg20.splitwise.command;

import com.dgarg20.splitwise.models.Command;
import com.dgarg20.splitwise.models.Expense;
import com.dgarg20.splitwise.models.ExpenseType;
import com.dgarg20.splitwise.models.UserShare;
import com.dgarg20.splitwise.repositories.UserRepository;
import com.dgarg20.splitwise.service.ExpenseServiceFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Deepanshu Garg on 03/09/21.
 */
public class AddExpenseCommand extends CommandExecutor{
    public void execute(Command command) {
        Expense expense = new Expense();
        expense.setSpendingUser(UserRepository.getInstance().getUser(command.getParameters().get(0)));
        expense.setAmount(Float.parseFloat(command.getParameters().get(1)));
        expense.setUsersInvolved(Integer.parseInt(command.getParameters().get(2)));
        expense.setExpenseType(ExpenseType.valueOf(command.getParameters().get(3 + expense.getUsersInvolved())));
        List<UserShare> userShares = new LinkedList<>();
        IntStream.range(0,expense.getUsersInvolved()-1)
                .forEach(x ->
                    userShares.add(new UserShare(UserRepository.getInstance().getUser(command.getParameters().get(x+3)),
                            Float.parseFloat(command.getParameters().get(x+expense.getUsersInvolved()+4)))));

        ExpenseServiceFactory expenseServiceFactory = new ExpenseServiceFactory();
        expenseServiceFactory.getExpenseService(expense.getExpenseType()).addExpense(expense);
    }



}