package com.dgarg20.stock_market.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Deepanshu Garg on 12/04/21.
 */
@NoArgsConstructor
@Getter
@Setter
public class Bid {
    private float price;
    private Queue<OrderRequest> orderQueue;

    public Bid(float price, OrderRequest order) {
        this.price = price;
        this.orderQueue = new LinkedList<OrderRequest>();
        this.orderQueue.add(order);
    }
}
