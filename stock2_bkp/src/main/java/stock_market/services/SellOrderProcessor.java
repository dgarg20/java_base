package com.dgarg20.stock_market.services;

import com.dgarg20.stock_market.entities.OrderRequest;
import com.dgarg20.stock_market.entities.StockPendingOrders;
import com.dgarg20.stock_market.exception.ServiceException;
import com.dgarg20.stock_market.repository.DriverClass;

import java.util.LinkedList;

import static com.dgarg20.stock_market.services.HelperMethods.printOrderMatch;

/**
 * Created by Deepanshu Garg on 18/04/21.
 */
public class SellOrderProcessor implements OrderProcessor {
    DriverClass dc = DriverClass.getInstance();

    @Override
    public void execute(OrderRequest orderRequest)throws ServiceException {
        if(!dc.stockOrdersExists(orderRequest.getStock())) {
            dc.addNewStockPendingOrders(orderRequest.getStock());
        }
        StockPendingOrders stockPendingOrders = dc.getPendingOrders(orderRequest.getStock());
        while (stockPendingOrders.getBuyOrders().size() !=0 && orderRequest.getQty() > 0) {
            Float availableBid = stockPendingOrders.getBuyOrders().peek();
            if(availableBid < orderRequest.getPrice())
                break;
            while (orderRequest.getQty() > 0 && !stockPendingOrders.getBuyPendingBids().get(availableBid).isEmpty() && availableBid > orderRequest.getPrice()) {
                if (stockPendingOrders.getBuyPendingBids().get(availableBid).peek().getQty() > orderRequest.getQty()) {
                    stockPendingOrders.getBuyPendingBids().get(availableBid).peek().setQty(stockPendingOrders.getBuyPendingBids().get(availableBid).peek().getQty() - orderRequest.getQty());
                    printOrderMatch(stockPendingOrders.getBuyPendingBids().get(availableBid).peek().getOrderId(), orderRequest.getPrice(), orderRequest.getOrderId(), orderRequest.getQty());
                    orderRequest.setQty(0);
                    break;
                } else if (stockPendingOrders.getBuyPendingBids().get(availableBid).peek().getQty() <= orderRequest.getQty()) {
                    printOrderMatch(stockPendingOrders.getBuyPendingBids().get(availableBid).peek().getOrderId(),  orderRequest.getPrice(), orderRequest.getOrderId(), stockPendingOrders.getBuyPendingBids().get(availableBid).peek().getQty());
                    orderRequest.setQty(orderRequest.getQty() - stockPendingOrders.getBuyPendingBids().get(availableBid).peek().getQty());
                    stockPendingOrders.getBuyPendingBids().get(availableBid).poll();
                }
            }
            if (stockPendingOrders.getBuyPendingBids().get(availableBid).isEmpty())
                stockPendingOrders.getBuyOrders().poll();
        }


        if(orderRequest.getQty() > 0){
            if(!stockPendingOrders.getSellPendingBids().containsKey(orderRequest.getPrice())) {
                stockPendingOrders.getSellOrders().add(orderRequest.getPrice());
                stockPendingOrders.getSellPendingBids().put(orderRequest.getPrice(), new LinkedList());
            }
            stockPendingOrders.getSellPendingBids().get(orderRequest.getPrice()).add(orderRequest);
        }
    }
}
