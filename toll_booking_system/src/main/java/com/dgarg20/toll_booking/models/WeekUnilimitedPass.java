package com.dgarg20.toll_booking.models;

import java.time.LocalDateTime;

/**
 * Created by Deepanshu Garg on 30/01/21.
 */
public class WeekUnilimitedPass implements Pass {
    private PassType passType = PassType.WEEK_UNLIMITED;
    private LocalDateTime expiryTime;
    private boolean isPassActivated = false;

    public WeekUnilimitedPass(){
        this.expiryTime = LocalDateTime.now().plusWeeks(1);
    }


    @Override
    public boolean isValid() {
        return expiryTime.isBefore(LocalDateTime.now());
    }

    @Override
    public void changeValidity() {

    }
}
