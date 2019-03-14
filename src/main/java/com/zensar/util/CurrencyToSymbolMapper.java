package com.zensar.util;

import java.util.HashMap;
import java.util.Map;

public class CurrencyToSymbolMapper {

    private static final Map<String, String> currencyMap;

    static{
        currencyMap = new HashMap<>();
        currencyMap.put("GBP", "£");
        currencyMap.put("USD", "$");
    }

    public static String getCurrencySymbol(String currency){
        return currencyMap.get(currency);
    }

}
