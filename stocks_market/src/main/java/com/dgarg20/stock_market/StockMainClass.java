package com.dgarg20.stock_market;

import com.dgarg20.stock_market.Exception.ServiceException;
import com.dgarg20.stock_market.entities.OrderRequest;
import com.dgarg20.stock_market.entities.StockOrdersPending;
import com.dgarg20.stock_market.service.FileService;
import com.dgarg20.stock_market.service.OrderService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Deepanshu Garg on 12/04/21.
 */
public class StockMainClass {

    public static void main(String[] args) throws ServiceException {
        FileService fileService = new FileService();
        OrderService orderService = new OrderService();
        Map<String, StockOrdersPending> stocksOrders = new HashMap<>();
        try {
            List<OrderRequest> orderRequestList = fileService.getOrdersFromFile(args[0]);
            orderService.sortOrdersOnTime(orderRequestList);
            for (OrderRequest orderRequest: orderRequestList){
                if(!stocksOrders.containsKey(orderRequest.getStock().toLowerCase())) {
                    stocksOrders.put(orderRequest.getStock().toLowerCase(), new StockOrdersPending());
                }

                stocksOrders.get(orderRequest.getStock().toLowerCase()).matchOrder(orderRequest);

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
