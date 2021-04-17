package com.dgarg20.java_base.service;

import com.dgarg20.java_base.driver.DriverClass;
import com.dgarg20.java_base.dtos.*;
import com.dgarg20.java_base.exceptions.TempException;
import com.dgarg20.java_base.requests.AddExpense;
import com.dgarg20.java_base.response.SummaryResponse;

import java.util.*;
import java.util.stream.Collectors;

public class ExpenseServiceImpl implements ExpenseService{
    DriverClass driverClass = DriverClass.getInstance();
    @Override
    public void getExpenseByID(Long Id) {

    }

    public void addExpense(AddExpense addExpense, String user)throws TempException {
        Optional<User> user1 = driverClass.getUserByName(user);
        Optional<Group> group = driverClass.getGroupById(addExpense.getGroupId());
        if(!(user1.isPresent() && group.isPresent()))
            throw new TempException("group not found or you are not a valid user");

        Expense expense = new Expense(driverClass.getNextExpenseId(), addExpense.getExpenseName(),
                addExpense.getAmount(), group.get(), addExpense.getSplitType(), user1.get(),addExpense.getUserShares());
        List<ExpenseSplitter> expenseSplitter = new LinkedList<>();
        if(addExpense.getSplitType().equals(SplitType.EQUAL)){
            int persons = group.get().getUsers().size();
            float eachShare = (float)addExpense.getAmount() / persons;
            for(User user2: group.get().getUsers())
                if(user2.getId() != user1.get().getId())
                    expenseSplitter.add(new ExpenseSplitter(user2, user1.get(),  eachShare, expense));
        }
        else if(addExpense.getSplitType().equals(SplitType.PERCENTAGE)){
            for(UserShare user2: addExpense.getUserShares()) {
                Optional<User> usr = driverClass.getUserById(user2.getUserId());
                if(!usr.isPresent())
                    throw new TempException("User Not found");
                if (user2.getUserId() != user1.get().getId())
                    expenseSplitter.add(new ExpenseSplitter(usr.get(), user1.get(),  addExpense.getAmount()* (user2.getValue()/100), expense));
            }
        }
        else if(addExpense.getSplitType().equals(SplitType.FIXED)){
            for(UserShare user2: addExpense.getUserShares()) {
                Optional<User> usr = driverClass.getUserById(user2.getUserId());
                if(!usr.isPresent())
                    throw new TempException("User Not found");
                if (user2.getUserId() != user1.get().getId())
                    expenseSplitter.add(new ExpenseSplitter(usr.get(), user1.get(),  user2.getValue(), expense));
            }
        }
        driverClass.getExpenses().add(expense);
        driverClass.setNextExpenseId(driverClass.getNextExpenseId() + 1);
        driverClass.addExpenseSplitters(expenseSplitter);
    }


    public SummaryResponse getSummary(int userId){
        List<ExpenseSplitter> expenseSplitters = driverClass.getExpenseSplitters();
        List<ExpenseSplitter> userInvolved = expenseSplitters.stream().filter(x ->
                (x.getOwedBy().getId() ==userId || x.getOwedTo().getId() ==userId)).collect(Collectors.toList());

        Map<Integer, Float> userIdToAmountMap = new HashMap<>();
        for(ExpenseSplitter expenseSplitter: userInvolved) {
            if(expenseSplitter.getOwedTo().getId() == userId) {
                if(!userIdToAmountMap.containsKey(expenseSplitter.getOwedBy().getId()))
                    userIdToAmountMap.put(expenseSplitter.getOwedBy().getId(), expenseSplitter.getAmount());
                else
                    userIdToAmountMap.put(expenseSplitter.getOwedBy().getId(), userIdToAmountMap.get(expenseSplitter.getOwedBy().getId())+expenseSplitter.getAmount());
            }
            if(expenseSplitter.getOwedBy().getId() == userId) {
                if(!userIdToAmountMap.containsKey(expenseSplitter.getOwedTo().getId()))
                    userIdToAmountMap.put(expenseSplitter.getOwedTo().getId(), - expenseSplitter.getAmount());
                else
                    userIdToAmountMap.put(expenseSplitter.getOwedTo().getId(), userIdToAmountMap.get(expenseSplitter.getOwedTo().getId()) - expenseSplitter.getAmount());
            }
        }

        List<UserShare> owedTo = new LinkedList<>();
        List<UserShare> owedFrom = new LinkedList<>();
        for (Map.Entry<Integer, Float> entry: userIdToAmountMap.entrySet()) {
            if(entry.getValue() > 0 ){
                owedFrom.add(new UserShare(entry.getKey(), Math.abs(entry.getValue())));
            }
            if(entry.getValue() < 0 ){
                owedTo.add(new UserShare(entry.getKey(), Math.abs(entry.getValue())));
            }
        }
        return new SummaryResponse(owedTo, owedFrom);
    }
}
