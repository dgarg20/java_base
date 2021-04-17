package com.dgarg20.java_base.dtos;

import lombok.*;

import java.util.List;

/**
 * Created by Deepanshu Garg on 16/12/20.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
    private int expenseId;
    private String expenseName;
    private int amount;
    private Group group;
    private SplitType splitType;
    private User paidBy;
    private List<UserShare> userShares;
}
