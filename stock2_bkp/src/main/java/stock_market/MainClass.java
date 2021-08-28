package com.dgarg20.stock_market;

import com.dgarg20.stock_market.entities.OrderRequest;
import com.dgarg20.stock_market.exception.ServiceException;
import com.dgarg20.stock_market.services.*;

import java.util.List;

/**
 * Created by Deepanshu Garg on 18/04/21.
 */
public class MainClass {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        OrderService orderService = new OrderService();

        try {
            List<OrderRequest> orderRequestList = fileService.getOrdersFromFile(args[0]);
            orderService.sortOrdersOnTime(orderRequestList);
            for (OrderRequest orderRequest: orderRequestList){
                OrderProcessor orderProcessor;
                switch (orderRequest.getOrderType()){
                    case BUY: {
                        orderProcessor = new BuyOrderProcessor();
                        break;
                    }

                    case SELL:{
                        orderProcessor = new SellOrderProcessor();
                        break;
                    }
                    default:
                        throw new IllegalStateException("Unexpected value: " + orderRequest.getOrderType());
                }
                orderProcessor.execute(orderRequest);
            }
            System.out.println("Finished");
        }
        catch (ServiceException ex){
            System.out.println(ex.getMessage());
        }
        catch (Exception ex){
            System.out.println("Something went Wrong");
        }
    }
}
