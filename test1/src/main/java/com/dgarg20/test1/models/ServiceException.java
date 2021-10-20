package com.dgarg20.test1.models;

import lombok.Getter;

/**
 * Created by Deepanshu Garg on 30/01/21.
 */
public class ServiceException extends Exception{
    @Getter
    private String message;
    public ServiceException(String message ){
        super(message);
        this.message = message;
    }
}
