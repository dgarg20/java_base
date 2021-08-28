package com.dgarg20.stock_market.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Deepanshu Garg on 18/04/21.
 */
@Getter
@Setter
public class StockPendingOrders {
    private PriorityQueue<Float> buyOrders;
    private PriorityQueue<Float> sellOrders;
    private Map<Float, Queue<OrderRequest>> buyPendingBids;
    private Map<Float, Queue<OrderRequest>> sellPendingBids;


    public StockPendingOrders(){
        this.buyOrders = new PriorityQueue<Float>((o1, o2) -> {
            if(o1 < o2)
                return 1;
            else return -1;
        });

        this.sellOrders = new PriorityQueue<Float>((o1, o2) -> {
            if(o1 < o2)
                return -1;
            else return 1;
        });
        buyPendingBids = new HashMap<>();
        sellPendingBids = new HashMap<>();
    }
}
