package de.github.sebyplays.consoleprinterapi.api;

import de.github.sebyplays.consoleprinterapi.utils.DateUtil;
import de.github.sebyplays.consoleprinterapi.utils.SystemProperty;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

public class ConsolePrinter {
    private static ConsolePrinter consolePrinter = new ConsolePrinter();
    private SystemProperty systemProperty = new SystemProperty();
    public static void print(String string, boolean colored, boolean time){
        // §0 == BLACK; §1 == RED; §2 == GREEN; §3 == YELLOW; §4 == BLUE; §5 == MAGENTA; §6== CYAN; §7 == WHITE; §8 == RESET;
        DateUtil dateUtil = new DateUtil();
        if (colored){
            if(consolePrinter.systemProperty.getOS() == OperatingSystem.WINDOWS || consolePrinter.systemProperty.getOS() == OperatingSystem.LINUX){
                consolePrinter.install();
                string = consolePrinter.colorize(string);
                consolePrinter.uninstall();
            } else {
                ConsolePrinter.print("Your System isn't officially supported yet!\n           Some features might not be available due to an unidentified OS.\n           Please report this incident here:\n           https://github.com/sebyplays/Java-ConsolePrinter-API/issues", false, true);
            }
        }
        if(time){ System.out.println(dateUtil.getTime() + string); }else{ System.out.println(string); }
        return;
    }

    private void install(){
        AnsiConsole.systemInstall();
        return;
    }

    private void uninstall(){
        AnsiConsole.systemUninstall();
        return;
    }

    private String colorize(String message){
        String result = "";
        String[] splitMessage = message.split(" ");
        for(int i = 0; i < splitMessage.length; i++){
            if(splitMessage[i].contains("§0")){
                splitMessage[i] = splitMessage[i].replaceAll("§0","");
                splitMessage[i] = String.valueOf(ansi().eraseScreen().fg(BLACK).a(splitMessage[i]));
            }
            if(splitMessage[i].contains("§1")){
                splitMessage[i] = splitMessage[i].replaceAll("§1","");
                splitMessage[i] = String.valueOf(ansi().eraseScreen().fg(RED).a(splitMessage[i]));
            }
            if(splitMessage[i].contains("§2")){
                splitMessage[i] = splitMessage[i].replaceAll("§2","");
                splitMessage[i] = String.valueOf(ansi().eraseScreen().fg(GREEN).a(splitMessage[i]));
            }
            if(splitMessage[i].contains("§3")){
                splitMessage[i] = splitMessage[i].replaceAll("§3","");
                splitMessage[i] = String.valueOf(ansi().eraseScreen().fg(YELLOW).a(splitMessage[i]));
            }
            if(splitMessage[i].contains("§4")){
                splitMessage[i] = splitMessage[i].replaceAll("§4","");
                splitMessage[i] = String.valueOf(ansi().eraseScreen().fg(BLUE).a(splitMessage[i]));
            }
            if(splitMessage[i].contains("§5")){
                splitMessage[i] = splitMessage[i].replaceAll("§5","");
                splitMessage[i] = String.valueOf(ansi().eraseScreen().fg(MAGENTA).a(splitMessage[i]));
            }
            if(splitMessage[i].contains("§6")){
                splitMessage[i] = splitMessage[i].replaceAll("§6","");
                splitMessage[i] = String.valueOf(ansi().eraseScreen().fg(CYAN).a(splitMessage[i]));
            }
            if(splitMessage[i].contains("§7")){
                splitMessage[i] = splitMessage[i].replaceAll("§7","");
                splitMessage[i] = String.valueOf(ansi().eraseScreen().fg(WHITE).a(splitMessage[i]));
            }
            if(splitMessage[i].contains("§8")){
                splitMessage[i] = splitMessage[i].replaceAll("§8","");
                splitMessage[i] = String.valueOf(ansi().eraseScreen().fg(DEFAULT).a(splitMessage[i]));
            }
            result = result + splitMessage[i] + " ";
        }
        return result;
    }

}
