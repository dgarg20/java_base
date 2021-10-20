package com.dgarg20.test1.task;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Deepanshu Garg on 01/07/21.
 */

@Data
@AllArgsConstructor
public class VoteObj {
    private String candidate;
    private int weight;
}
