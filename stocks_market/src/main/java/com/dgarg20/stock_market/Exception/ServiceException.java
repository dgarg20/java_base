package com.dgarg20.stock_market.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Deepanshu Garg on 12/04/21.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ServiceException extends Exception {
    private String code;
    private String message;
}
