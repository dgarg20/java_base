package com.dgarg20.java_base.movie_booking.repository;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Deepanshu Garg on 16/12/20.
 */

@Getter
@Setter
public class DriverClass {
    private int nextGroupId = 1;
    private int nextExpenseId = 1;
    private static DriverClass driverClass;

    private DriverClass(){
    }




    public static DriverClass getInstance(){
        if (driverClass ==null) {
            driverClass = new DriverClass();
        }
        return driverClass;
    }
}
