package com.dgarg20.toll_booking.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Deepanshu Garg on 30/01/21.
 */
public class RoundTripPass implements Pass{
    @Setter
    @Getter
    private int count = 1;

    @Override
    public boolean isValid() {
        return count > 0;
    }

    @Override
    public void changeValidity() {
        count = 0;
    }
}
