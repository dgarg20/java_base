package com.dgarg20.stock_market.service;

import com.dgarg20.stock_market.entities.OrderRequest;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Deepanshu Garg on 12/04/21.
 */
public class OrderService {
    public void sortOrdersOnTime(List<OrderRequest> orderRequests){
        orderRequests.sort(new Comparator<OrderRequest>() {
            @Override
            public int compare(OrderRequest o1, OrderRequest o2) {
                if(o1.getTime().isBefore(o2.getTime()))
                    return 0;
                else
                    return 1;
            }
        });
    }
}
