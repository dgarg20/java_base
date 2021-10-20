package com.dgarg20.test.model;

import java.util.Arrays;
import java.util.List;


public enum ExpenseSplitType {
    EQUAL,
    PERCENTAGE,
    EXACT;


    public static List<String> expenseTypes()
    {

        return Arrays.asList("EQUAL", "PERCENTAGE", "EXACT");
    }

}
