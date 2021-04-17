package com.dgarg20.toll_booking.models;

/**
 * Created by Deepanshu Garg on 30/01/21.
 */
public class SinglePass implements Pass{
    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void changeValidity() {

    }
}
