package com.dgarg20.java_base.requests;

import com.dgarg20.java_base.dtos.SplitType;
import com.dgarg20.java_base.dtos.UserShare;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddExpense {
    private String expenseName;
    private int groupId;
    private int amount;
    private SplitType splitType;
    private List<UserShare> userShares;
}
