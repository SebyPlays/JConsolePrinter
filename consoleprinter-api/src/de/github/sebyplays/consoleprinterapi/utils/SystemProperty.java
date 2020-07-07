package de.github.sebyplays.consoleprinterapi.utils;

import de.github.sebyplays.consoleprinterapi.api.ConsolePrinter;
import de.github.sebyplays.consoleprinterapi.api.OperatingSystem;

public class SystemProperty {

    public OperatingSystem getOS(){
            if(System.getProperty("os.name").toLowerCase().contains("win")){
                return OperatingSystem.WINDOWS;
            }
            if(System.getProperty("os.name").toLowerCase().contains("nux")){
                return OperatingSystem.LINUX;
            }
            return OperatingSystem.OTHER;
    }
}
