package de.github.sebyplays.consoleprinterapi.api;

import de.github.sebyplays.consoleprinterapi.utils.DateUtil;
import de.github.sebyplays.consoleprinterapi.utils.SystemProperty;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.io.Console;
import java.util.HashMap;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

public class ConsolePrinter {
    private HashMap<String, Ansi.Color> colorHashMap = new HashMap<String, Ansi.Color>(){
        {
            put("§0", BLACK);
            put("§1", RED);
            put("§2", GREEN);
            put("§3", YELLOW);
            put("§4", BLUE);
            put("§5", MAGENTA);
            put("§6", CYAN);
            put("§7", WHITE);
            put("§8", DEFAULT);
        }
    };
    private static ConsolePrinter consolePrinter = new ConsolePrinter();
    private SystemProperty systemProperty = new SystemProperty();

    public static void print(String string, boolean colored, boolean time){
        System.out.println(getString(string, colored, time));
    }

    public static String getString(String string, boolean colored, boolean time){
        DateUtil dateUtil = new DateUtil();
        if (colored){
            if(consolePrinter.systemProperty.getOS() != OperatingSystem.OTHER){
                AnsiConsole.systemInstall();
                string = consolePrinter.colorize(string);
                AnsiConsole.systemUninstall();
            } else {
                ConsolePrinter.print("Your System isn't officially supported yet!\n           Some features might not be available due to an unidentified OS.\n           Please report this incident here:\n           https://github.com/sebyplays/Java-ConsolePrinter-API/issues", false, true);
            }
        }
        String processedString;
        if(time){ processedString = dateUtil.getTime() + string; }else{ processedString = string;}
        return processedString;
    }

    private String colorize(String message){
        String result = "";
        String[] splitMessage = message.split(" ");
        for(int i = 0; i < splitMessage.length; i++){
            if(splitMessage[i].contains("§" + i)){
                splitMessage[i] = splitMessage[i].replaceAll("§" + i,"");
                splitMessage[i] = String.valueOf(ansi().eraseScreen().fg(colorHashMap.get("§" + i)).a(splitMessage[i]).fg(DEFAULT));
            }
            result = result + splitMessage[i] + " ";
        }
        return result;
    }
}
