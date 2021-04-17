package com.dgarg20.java_base.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonIgnoreProperties
public class ServiceException extends Exception{
    private ServiceErrors serviceError;
    private String message;

    public ServiceException(ServiceErrors serviceError){
        this.serviceError = serviceError;
        this.message = serviceError.getMessage();
    }

    public ServiceException(ServiceErrors serviceError, String message){
        this.serviceError = serviceError;
        this.message = message;
    }
}
