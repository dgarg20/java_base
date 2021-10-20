package com.dgarg20.splitwise.models;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Deepanshu Garg on 03/09/21.
 */

public class Expense {
    private User spendingUser;
    private float amount;
    private List<UserShare> userShareList;
    private int usersInvolved;
    private ExpenseType expenseType;

    public Expense(){
        userShareList = new LinkedList<UserShare>();
    }

    public Expense(User spendingUser, float amount, List<UserShare> userShareList, int usersInvolved, ExpenseType expenseType) {
        this.spendingUser = spendingUser;
        this.amount = amount;
        this.userShareList = userShareList;
        this.usersInvolved = usersInvolved;
        this.expenseType = expenseType;
    }

    public User getSpendingUser() {
        return spendingUser;
    }

    public void setSpendingUser(User spendingUser) {
        this.spendingUser = spendingUser;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public List<UserShare> getUserShareList() {
        return userShareList;
    }

    public void setUserShareList(List<UserShare> userShareList) {
        this.userShareList = userShareList;
    }

    public int getUsersInvolved() {
        return usersInvolved;
    }

    public void setUsersInvolved(int usersInvolved) {
        this.usersInvolved = usersInvolved;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }
}
