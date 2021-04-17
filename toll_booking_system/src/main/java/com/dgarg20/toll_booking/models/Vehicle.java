package com.dgarg20.toll_booking.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Deepanshu Garg on 30/01/21.
 */
@AllArgsConstructor
@Getter
@Setter
public class Vehicle {
    private String id;
    private VehicleType vehicleType;
}
