package com.dgarg20.stock_market.entities;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Deepanshu Garg on 12/04/21.
 */
public class StockOrdersPending {
    PriorityQueue<Bid> buyOrders;
    PriorityQueue<Bid> sellOrders;

    public StockOrdersPending(){
       this.buyOrders = new PriorityQueue<Bid>((o1, o2) -> {
           if(o1.getPrice() < o2.getPrice())
               return 1;
           else return -1;
       });

        this.sellOrders = new PriorityQueue<Bid>((o1, o2) -> {
            if(o1.getPrice() < o2.getPrice())
                return -1;
            else return 1;
        });
    }

    public void matchOrder(OrderRequest orderRequest) {
        if (orderRequest.getOrderType() == OrderType.BUY) {
            while (!sellOrders.isEmpty() && orderRequest.getQty() > 0) {
                Bid availableBid = sellOrders.peek();
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
                    sellOrders.poll();
            }

            if (orderRequest.getQty() > 0) {
                buyOrders.iterator().forEachRemaining(x -> {
                    if (x.getPrice() == orderRequest.getPrice()) {
                        x.getOrderQueue().add(orderRequest);
                        return;
                    }
                });
            }
                buyOrders.add(new Bid(orderRequest.getPrice(), orderRequest));
        }


        else {
            while (!buyOrders.isEmpty() && orderRequest.getQty() > 0) {
                Bid availableBid = buyOrders.peek();
                if(availableBid.getPrice() < orderRequest.getPrice())
                    break;
                while (orderRequest.getQty() > 0 && !availableBid.getOrderQueue().isEmpty() && availableBid.getPrice() > orderRequest.getPrice()) {
                    if (availableBid.getOrderQueue().peek().getQty() > orderRequest.getQty()) {
                        availableBid.getOrderQueue().peek().setQty(availableBid.getOrderQueue().peek().getQty() - orderRequest.getQty());
                        printOrderMatch(availableBid.getOrderQueue().peek().getOrderId(), orderRequest.getPrice(), orderRequest.getOrderId(), orderRequest.getQty());
                        orderRequest.setQty(0);
                        break;
                    } else if (availableBid.getOrderQueue().peek().getQty() <= orderRequest.getQty()) {
                        printOrderMatch(availableBid.getOrderQueue().peek().getOrderId(),  orderRequest.getPrice(), orderRequest.getOrderId(), availableBid.getOrderQueue().peek().getQty());
                        orderRequest.setQty(orderRequest.getQty() - availableBid.getOrderQueue().peek().getQty());
                        availableBid.getOrderQueue().poll();
                    }
                }
                if (availableBid.getOrderQueue().isEmpty())
                    buyOrders.poll();
            }

            if (orderRequest.getQty() > 0) {
                sellOrders.iterator().forEachRemaining(x -> {
                    if (x.getPrice() == orderRequest.getPrice()) {
                        x.getOrderQueue().add(orderRequest);
                        return;
                    }
                });
            }
            sellOrders.add(new Bid(orderRequest.getPrice(), orderRequest));
        }
    }


    public void addBid(Bid bid, OrderType orderType){
        if(orderType == OrderType.BUY)
            buyOrders.add(bid);
        else sellOrders.add(bid);
    }

    public void printOrderMatch(String buyOrderId, float price, String sellOrderId, int qty){
        System.out.println(buyOrderId + " " + price + " "  + qty + " " + sellOrderId);
    }
}
