package com.dgarg20.stock_market.repository;

import com.dgarg20.stock_market.entities.StockPendingOrders;
import com.dgarg20.stock_market.exception.ServiceException;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Deepanshu Garg on 18/04/21.
 */
@Getter
@Setter
public class DriverClass {
    private static DriverClass driverClass;
    private Map<String, StockPendingOrders> stocksOrders = new HashMap<>();

    public static DriverClass getInstance(){
        if (driverClass ==null) {
            driverClass = new DriverClass();
        }
        return driverClass;
    }

    public boolean stockOrdersExists(String stock)throws ServiceException {
        return stocksOrders.containsKey(stock.toLowerCase());
    }

    public StockPendingOrders getPendingOrders(String stock)throws ServiceException {
        if(stocksOrders.containsKey(stock.toLowerCase()))
            return stocksOrders.get(stock.toLowerCase());
        else
            throw new ServiceException("400", "StockNotFoundException");
    }

    public void addNewStockPendingOrders(String stock )throws ServiceException {
        if(stocksOrders.containsKey(stock.toLowerCase()))
            throw new ServiceException("400", "Stock Already Exists");
        else
            stocksOrders.put(stock.toLowerCase(), new StockPendingOrders());
    }
}
