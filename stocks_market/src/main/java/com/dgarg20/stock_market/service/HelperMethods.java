package com.dgarg20.stock_market.service;

/**
 * Created by Deepanshu Garg on 12/04/21.
 */
public class HelperMethods {
    public static <T extends Enum<?>> T searchEnum(Class<T> enumeration,
                                                   String search) {
        for (T each : enumeration.getEnumConstants()) {
            if (each.name().compareToIgnoreCase(search) == 0) {
                return each;
            }
        }
        return null;
    }
}
