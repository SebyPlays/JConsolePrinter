package com.github.sebyplays.consoleprinterapi.utils;

public class SystemProperty {

    private OperatingSystem getOS() {
            if(System.getProperty("os.name").toLowerCase().contains("win")) return OperatingSystem.WINDOWS;
            return OperatingSystem.OTHER;
    }

    public boolean installJansi() {
        return (getOS() == OperatingSystem.WINDOWS);
    }

    public enum OperatingSystem {
        WINDOWS,
        OTHER
    }
}
