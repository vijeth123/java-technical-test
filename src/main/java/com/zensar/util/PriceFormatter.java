package com.zensar.util;

public class PriceFormatter {
    public static String format(String currencySymbol, String price){
        Double priceDouble = (!price.isEmpty()) ? Double.parseDouble(price) : 0.0;
        if(priceDouble > 10){
            return currencySymbol + String.valueOf(priceDouble.intValue());
        }
        return currencySymbol + String.valueOf(priceDouble);
    }
}
