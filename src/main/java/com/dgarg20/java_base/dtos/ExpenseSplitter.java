package com.dgarg20.java_base.dtos;

import lombok.*;

/**
 * Created by Deepanshu Garg on 16/12/20.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseSplitter {
    private User owedBy;
    private User owedTo;
    private float amount;
    private Expense exp;
}
