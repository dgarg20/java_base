package com.dgarg20.toll_booking.models;

import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Deepanshu Garg on 30/01/21.
 */


@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Toll {
    private String id;

    private List<TollBooth> tollBooths;
    @Getter
    @Setter
    private FareRates fareRates;
    @Getter
    @Setter
    private Map<String, Pass> vehiclePass;

    public void tollSummary(){
        int totalFareCollected = tollBooths.stream().mapToInt(TollBooth::getAmountCollected).sum();
        int totalVehicles = tollBooths.stream().mapToInt(TollBooth::getVehiclesPassed).sum();
        System.out.println("Total Vehicles Passed = " + totalVehicles + "\n Total Amount Collected = "+ totalFareCollected);
    }


    public TollBooth getTollBooth(String id) throws ServiceException {
        for(TollBooth tb: tollBooths) {
            if(tb.getId().equalsIgnoreCase(id))
                return tb;
        }
            throw new ServiceException("Toll Booth with Id " + id + "doesNot Exists");
    }

    public void removeVehiclePass(String vehicleiId){
        vehiclePass.remove(vehicleiId);
    }



//    public void bulkBook(List<String>)

}
