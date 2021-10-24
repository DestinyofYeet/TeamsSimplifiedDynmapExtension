package me.destinyofyeet.TeamsSimplifiedDynmapExtension.utils;

import me.destinyofyeet.TeamsSimplifiedDynmapExtension.main.Main;

import java.util.HashMap;

public class ColorMapping {

    private static final HashMap<String, Integer> colorMap = new HashMap<>() {{
        put("&0", 0x000000); // black
        put("&1", 0x0000AA); // dark blue
        put("&2", 0x00AA00); // dark green
        put("&3", 0x00AAAA); // dark aqua
        put("&4", 0xAA0000); // dark red
        put("&5", 0xAA00AA); // dark purple
        put("&6", 0xFFAA00); // gold
        put("&7", 0xAAAAAA); // gray
        put("&8", 0x555555); // dark gray
        put("&9", 0x5555FF); // blue

        put("&a", 0x55FF55); // green
        put("&b", 0x55FFFF); // aqua
        put("&c", 0xFF5555); // red
        put("&d", 0xFF55FF); // light purple
        put("&e", 0xFFFF55); // yellow

        put("&f", 0xFFFFFF); // white
    }};

    public static int getColor(String teamColor){
        final int defaultColor = colorMap.get("&7");

        if (teamColor == null || teamColor.length() == 0){
            return defaultColor;
        }

        for(String color: teamColor.split("&")){
            Object result = colorMap.get("&" + color);

            if (result == null)
                continue;

            return (int) result;
        }

        return defaultColor;
    }
}
