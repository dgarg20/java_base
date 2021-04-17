package com.dgarg20.toll_booking.services;

import com.dgarg20.test1.models.*;
import com.dgarg20.test1.repository.DriverClass;

/**
 * Created by Deepanshu Garg on 30/01/21.
 */
public class TollBoothService {
    DriverClass dc = DriverClass.getInstance();
    public void puchaseToll(String vehicleId, String tollId, String boothId, VehicleType vehicleType, PassType passType)throws ServiceException {
        Toll toll = dc.getToll(tollId);
        TollBooth tollBooth = toll.getTollBooth(boothId);
        Pass p;

        int fare = toll.getFareRates().getFares().get(vehicleType).get(passType);

        tollBooth.setAmountCollected(tollBooth.getAmountCollected() + fare);
        tollBooth.setVehiclesPassed(tollBooth.getVehiclesPassed() + 1);

        switch (passType) {
            case ROUNDTRIP: {
                Pass pass = new RoundTripPass();
                toll.getVehiclePass().put(vehicleId, pass);
                break;

            }
            case SINGLE: {

                return;
            }
            case WEEK_UNLIMITED:{
                Pass pass = new WeekUnilimitedPass();
                toll.getVehiclePass().put(vehicleId, pass);
                break;
            }
        }
    }
}
