package com.dgarg20.stock_market.service;

import com.dgarg20.stock_market.Exception.ServiceException;
import com.dgarg20.stock_market.entities.Bid;
import com.dgarg20.stock_market.entities.OrderRequest;
import com.dgarg20.stock_market.entities.StockPendingOrders;
import com.dgarg20.stock_market.repository.DriverClass;

import static com.dgarg20.stock_market.service.HelperMethods.printOrderMatch;

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
            Bid availableBid = stockPendingOrders.getSellOrders().peek();
            if(availableBid.getPrice() > orderRequest.getPrice())
                break;
            while (orderRequest.getQty() > 0 && !availableBid.getOrderQueue().isEmpty() && availableBid.getPrice() < orderRequest.getPrice()) {
                if (availableBid.getOrderQueue().peek().getQty() > orderRequest.getQty()) {
                    availableBid.getOrderQueue().peek().setQty(availableBid.getOrderQueue().peek().getQty() - orderRequest.getQty());
                    printOrderMatch(orderRequest.getOrderId(), availableBid.getPrice(), availableBid.getOrderQueue().peek().getOrderId(), orderRequest.getQty());
                    orderRequest.setQty(0);
                    break;
                } else if (availableBid.getOrderQueue().peek().getQty() <= orderRequest.getQty()) {
                    printOrderMatch(orderRequest.getOrderId(), availableBid.getPrice(), availableBid.getOrderQueue().peek().getOrderId(), availableBid.getOrderQueue().peek().getQty());
                    orderRequest.setQty(orderRequest.getQty() - availableBid.getOrderQueue().peek().getQty());
                    availableBid.getOrderQueue().poll();
                }
            }
            if (availableBid.getOrderQueue().isEmpty())
                stockPendingOrders.getSellOrders().poll();
        }

        if (orderRequest.getQty() > 0) {
            stockPendingOrders.getBuyOrders().iterator().forEachRemaining(x -> {
                if (x.getPrice() == orderRequest.getPrice()) {
                    x.getOrderQueue().add(orderRequest);
                    orderRequest.setQty(0);
                    return;
                }
            });
        }
        if (orderRequest.getQty() > 0) {
            stockPendingOrders.getBuyOrders().add(new Bid(orderRequest.getPrice(), orderRequest));
        }
    }
}
