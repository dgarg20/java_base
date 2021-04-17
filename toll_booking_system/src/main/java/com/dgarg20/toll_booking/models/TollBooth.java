package com.dgarg20.toll_booking.models;

import lombok.*;

/**
 * Created by Deepanshu Garg on 30/01/21.
 */

@Getter
@Setter
@NoArgsConstructor
@Builder
public class TollBooth {
    private String id;
    private int vehiclesPassed;
    private int amountCollected;

    public TollBooth(String id){
        this.id = id;
        this.vehiclesPassed = 0;
        this.amountCollected = 0;
    }
}
