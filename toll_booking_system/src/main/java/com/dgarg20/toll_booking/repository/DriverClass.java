package com.dgarg20.toll_booking.repository;

import com.dgarg20.toll_booking.models.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Deepanshu Garg on 30/01/21.
 */

@Getter
@Setter
public class DriverClass {
    private int nextGroupId = 1;
    private int nextExpenseId = 1;
    private static DriverClass driverClass;
    private Map<String, Toll> tolls;

    private DriverClass(){
        Map<PassType, Integer> bike1 = new HashMap<>();
        bike1.put(PassType.ROUNDTRIP, 15);
        bike1.put(PassType.SINGLE, 10);
        bike1.put(PassType.WEEK_UNLIMITED, 100);

        Map<PassType, Integer> car1 = new HashMap<>();
        car1.put(PassType.ROUNDTRIP, 30);
        car1.put(PassType.SINGLE, 20);
        car1.put(PassType.WEEK_UNLIMITED, 200);


        Map<PassType, Integer> car2 = new HashMap<>();
        car2.put(PassType.ROUNDTRIP, 60);
        car2.put(PassType.SINGLE, 90);
        car2.put(PassType.WEEK_UNLIMITED, 400);

        Map<PassType, Integer> bike2 = new HashMap<>();
        bike2.put(PassType.ROUNDTRIP, 30);
        bike2.put(PassType.SINGLE, 20);
        bike2.put(PassType.WEEK_UNLIMITED, 200);

        Map<VehicleType, Map<PassType, Integer>> fareRates1 = new HashMap<>();

        Map<VehicleType, Map<PassType, Integer>> fareRates2 = new HashMap<>();

        fareRates1.put(VehicleType.BIKE, bike1);
        fareRates1.put(VehicleType.CAR, car1);
        fareRates2.put(VehicleType.BIKE, bike2);
        fareRates2.put(VehicleType.CAR, car2);


        FareRates fareToll1 = new FareRates(fareRates1);
        FareRates fareToll2 = new FareRates(fareRates2);

        TollBooth toll1B1 = new TollBooth("b1");
        TollBooth toll1B2 = new TollBooth("b2");
        TollBooth toll2B1 = new TollBooth("b1");
        Toll t1 = new Toll("t1", Arrays.asList(toll1B1, toll1B2), fareToll1, new HashMap<>());
        Toll t2 = new Toll("t2", Arrays.asList(toll1B1), fareToll2, new HashMap<>());
        this.tolls = new HashMap<>();
        this.tolls.put("t1", t1);
        this.tolls.put("t2", t2);

    }

    public static DriverClass getInstance(){
        if (driverClass ==null) {
            driverClass = new DriverClass();
        }
        return driverClass;
    }


    public Toll getToll(String tollId) throws ServiceException{
        if(tolls.containsKey(tollId)) {
            return tolls.get(tollId);
        }
        else
            throw new ServiceException("Toll with Id " + tollId + "doesNot Exists");
    }


}
