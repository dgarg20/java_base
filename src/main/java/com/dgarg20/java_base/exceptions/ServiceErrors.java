package com.dgarg20.java_base.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Deepanshu Garg on 29/11/20.
 */

@AllArgsConstructor
@Getter
public enum ServiceErrors {
    INTERNAL_SERVICE_ERROR(500, "Some thing Went wrong");

    private int httpStatusCode;
    private String message;
}
