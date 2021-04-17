package com.dgarg20.java_base.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Deepanshu Garg on 16/12/20.
 */
@Getter
@Setter
public class TempException extends Exception {
    private String message;
    public TempException(String message){
      super(message);
      this.message = message;
    }
}
