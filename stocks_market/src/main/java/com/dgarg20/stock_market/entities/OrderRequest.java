package com.dgarg20.stock_market.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

/**
 * Created by Deepanshu Garg on 12/04/21.
 */

@AllArgsConstructor
@Getter
@Setter
public class OrderRequest {
    private String orderId;
    private LocalTime time;
    private String stock;
    private OrderType orderType;
    private float price;
    private int qty;
}
