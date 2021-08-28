package com.dgarg20.stock_market.services;

/**
 * Created by Deepanshu Garg on 18/04/21.
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


    public static void printOrderMatch(String buyOrderId, float price, String sellOrderId, int qty){
        System.out.println(buyOrderId + " " + price + " "  + qty + " " + sellOrderId);
    }
}
