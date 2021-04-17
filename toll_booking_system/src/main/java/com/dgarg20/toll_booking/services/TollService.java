package com.dgarg20.toll_booking.services;

import com.dgarg20.test1.models.Pass;
import com.dgarg20.test1.models.ServiceException;
import com.dgarg20.test1.models.Toll;
import com.dgarg20.test1.repository.DriverClass;

/**
 * Created by Deepanshu Garg on 30/01/21.
 */
public class TollService {
    DriverClass dc = DriverClass.getInstance();


    public boolean AllowedToPass(String tollId,  String vehicleId) throws ServiceException {
        Toll toll =dc.getToll(tollId);

        if(toll.getVehiclePass().containsKey(vehicleId)){
            Pass p = toll.getVehiclePass().get(vehicleId);
            if(p.isValid()) {
                p.changeValidity();
                return true;
            }else {
                toll.removeVehiclePass(vehicleId);
                return false;
            }

        }else return false;
    }

    public void tollSummary(String tollId)throws ServiceException{
            dc.getToll(tollId).tollSummary();
    }

}
