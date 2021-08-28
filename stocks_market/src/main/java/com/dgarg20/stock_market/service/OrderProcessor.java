package com.dgarg20.stock_market.service;

import com.dgarg20.stock_market.Exception.ServiceException;
import com.dgarg20.stock_market.entities.OrderRequest;

/**
 * Created by Deepanshu Garg on 18/04/21.
 */
public interface OrderProcessor {
    void execute(OrderRequest orderRequest) throws ServiceException;
}
