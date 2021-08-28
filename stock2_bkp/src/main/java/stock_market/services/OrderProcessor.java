package com.dgarg20.stock_market.services;

import com.dgarg20.stock_market.entities.OrderRequest;
import com.dgarg20.stock_market.exception.ServiceException;

/**
 * Created by Deepanshu Garg on 18/04/21.
 */
public interface OrderProcessor {
    void execute(OrderRequest orderRequest) throws ServiceException;
}
