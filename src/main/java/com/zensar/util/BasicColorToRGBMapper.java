package com.zensar.util;

import java.util.HashMap;
import java.util.Map;

public class BasicColorToRGBMapper {

    private static final Map<String, String> colorMap;

    static{
        colorMap = new HashMap<>();
        colorMap.put("Red", "FF0000");
        colorMap.put("Lime", "00FF00");
        colorMap.put("Grey", "808080");
        colorMap.put("Blue", "0000FF");
        colorMap.put("Yellow", "FFFF00");
        colorMap.put("Cyan", "00FFFF");
        colorMap.put("Magenta", "FF00FF");
        colorMap.put("Silver", "C0C0C0");
        colorMap.put("Gray", "808080");
        colorMap.put("Maroon", "800000");
        colorMap.put("Olive", "808000");
        colorMap.put("Green", "008000");
        colorMap.put("Purple", "800080");
        colorMap.put("Teal", "008080");
        colorMap.put("Navy", "000080");
        colorMap.put("Maroon", "800000");
        colorMap.put("Dark red", "8B0000");
        colorMap.put("Brown", "A52A2A");
        colorMap.put("Firebrick", "B22222");
        colorMap.put("Crimson", "DC143C");
        colorMap.put("Tomato", "FF6347");
        colorMap.put("Coral", "FF7F50");
        colorMap.put("Indian red", "CD5C5C");
        colorMap.put("Light coral", "F08080");
        colorMap.put("Dark salmon", "E9967A");
        colorMap.put("Salmon", "FA8072");
        colorMap.put("Light salmon", "FFA07A");
        colorMap.put("Orange red", "FF4500");
        colorMap.put("Dark orange", "FF8C00");
        colorMap.put("Orange", "FFA500");
        colorMap.put("Gold", "FFD700");
        colorMap.put("Dark golden rod", "B8860B");
        colorMap.put("Golden rod", "DAA520");
        colorMap.put("Pale golden rod", "EEE8AA ");
        colorMap.put("Dark khaki", "BDB76B");
        colorMap.put("Khaki", "F0E68C");
        colorMap.put("Olive", "808000");
        colorMap.put("Yellow", "FFFF00");
        colorMap.put("Green", "008000");
        colorMap.put("Blue", "0000FF");
        colorMap.put("Purple", "800080");
        colorMap.put("Pink", "FFC0CB");
        colorMap.put("Black", "000000");
        colorMap.put("White", "FFFFFF");
        colorMap.put("Multi", "E6E6FA");
    }

    public static String getRGBColor(String basicColor){
        return colorMap.get(basicColor);
    }

}
