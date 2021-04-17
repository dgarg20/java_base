package com.dgarg20.toll_booking.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Created by Deepanshu Garg on 30/01/21.
 */
@Getter
@Setter
public class FareRates {
    @Getter
    private Map<VehicleType, Map<PassType, Integer>> fares;

    public FareRates(Map<VehicleType, Map<PassType, Integer>> fares){
        this.fares = fares;
    }

    public String display(VehicleType vehicleType){
        String disp = "";

        for(Map.Entry<PassType, Integer> entry: fares.get(vehicleType).entrySet()) {
            disp = disp + " Fare for " + entry.getKey().name() + " is Rs " + entry.getValue() + " \n";
        }
        return disp;
    }

}
