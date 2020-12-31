package com.github.sebyplays.consoleprinterapi.utils;

import java.util.HashMap;
import java.util.Map;

public class Colorizer {

    private HashMap<String, String> colors = new HashMap<String, String>() {
        {
            put("§f0", "\u001b[30m");
            put("§f1", "\u001b[34m");
            put("§f2", "\u001b[32m");
            put("§f3", "\u001b[36m");
            put("§f4", "\u001b[31m");
            put("§f5", "\u001b[35m");
            put("§f6", "\u001b[33m");
            put("§f7", "\u001b[37m");
            put("§f8", "\u001b[90m");
            put("§f9", "\u001b[94m");
            put("§fa", "\u001b[92m");
            put("§fb", "\u001b[96m");
            put("§fc", "\u001b[91m");
            put("§fd", "\u001b[95m");
            put("§fe", "\u001b[93m");
            put("§ff", "\u001b[97m");

            put("§b0", "\u001b[40m");
            put("§b1", "\u001b[44m");
            put("§b2", "\u001b[42m");
            put("§b3", "\u001b[46m");
            put("§b4", "\u001b[41m");
            put("§b5", "\u001b[45m");
            put("§b6", "\u001b[43m");
            put("§b7", "\u001b[47m");
            put("§b8", "\u001b[100m");
            put("§b9", "\u001b[104m");
            put("§ba", "\u001b[102m");
            put("§bb", "\u001b[106m");
            put("§bc", "\u001b[101m");
            put("§bd", "\u001b[105m");
            put("§be", "\u001b[103m");
            put("§bf", "\u001b[107m");

            put("§eb", "\u001b[1m");
            put("§eu", "\u001b[4m");

            put("§r", "\u001b[0m");
        }
    };

    public String colorize(String text) {
        for (Map.Entry<String, String> entry : colors.entrySet()) text = text.replace(entry.getKey(), entry.getValue());
        return text;
    }

}
