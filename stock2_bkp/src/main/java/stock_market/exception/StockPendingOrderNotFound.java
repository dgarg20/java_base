package com.dgarg20.stock_market.exception;

/**
 * Created by Deepanshu Garg on 18/04/21.
 */
public class StockPendingOrderNotFound extends ServiceException {
    public StockPendingOrderNotFound(){
        super("400", "Stock Not Found");
    }
}
