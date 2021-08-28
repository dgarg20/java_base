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
public class BuyOrderProcessor implements OrderProcessor {
    DriverClass dc = DriverClass.getInstance();
    @Override
    public void execute(OrderRequest orderRequest)throws ServiceException {
        if(!dc.stockOrdersExists(orderRequest.getStock())) {
            dc.addNewStockPendingOrders(orderRequest.getStock());
        }
        StockPendingOrders stockPendingOrders = dc.getPendingOrders(orderRequest.getStock());
        while (stockPendingOrders.getSellOrders().size()!=0 && orderRequest.getQty() > 0) {
            Float availableBid = stockPendingOrders.getSellOrders().peek();
            if(availableBid > orderRequest.getPrice())
                break;
            while (orderRequest.getQty() > 0 && !stockPendingOrders.getSellPendingBids().get(availableBid).isEmpty() && availableBid < orderRequest.getPrice()) {
                if (stockPendingOrders.getSellPendingBids().get(availableBid).peek().getQty() > orderRequest.getQty()) {
                    stockPendingOrders.getSellPendingBids().get(availableBid).peek().setQty(stockPendingOrders.getSellPendingBids().get(availableBid).peek().getQty() - orderRequest.getQty());
                    printOrderMatch(orderRequest.getOrderId(), availableBid, stockPendingOrders.getSellPendingBids().get(availableBid).peek().getOrderId(), orderRequest.getQty());
                    orderRequest.setQty(0);
                    break;
                } else if (stockPendingOrders.getSellPendingBids().get(availableBid).peek().getQty() <= orderRequest.getQty()) {
                    printOrderMatch(orderRequest.getOrderId(), availableBid, stockPendingOrders.getSellPendingBids().get(availableBid).peek().getOrderId(), stockPendingOrders.getSellPendingBids().get(availableBid).peek().getQty());
                    orderRequest.setQty(orderRequest.getQty() - stockPendingOrders.getSellPendingBids().get(availableBid).peek().getQty());
                    stockPendingOrders.getSellPendingBids().get(availableBid).poll();
                }
            }
            if (stockPendingOrders.getSellPendingBids().get(availableBid).isEmpty())
                stockPendingOrders.getSellOrders().poll();
        }

        if(orderRequest.getQty() > 0){
            if(!stockPendingOrders.getBuyPendingBids().containsKey(orderRequest.getPrice())) {
                stockPendingOrders.getBuyOrders().add(orderRequest.getPrice());
                stockPendingOrders.getBuyPendingBids().put(orderRequest.getPrice(), new LinkedList());
            }
            stockPendingOrders.getBuyPendingBids().get(orderRequest.getPrice()).add(orderRequest);
        }
    }
}
