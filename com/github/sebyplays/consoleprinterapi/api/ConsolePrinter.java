package com.github.sebyplays.consoleprinterapi.api;

import com.github.sebyplays.consoleprinterapi.utils.DateUtil;
import com.github.sebyplays.consoleprinterapi.utils.Colorizer;
import com.github.sebyplays.consoleprinterapi.utils.SystemProperty;
import org.fusesource.jansi.AnsiConsole;

public class ConsolePrinter {

    private static final DateUtil util = new DateUtil();
    private static final Colorizer colorizer = new Colorizer();
    private static boolean started = false;

    public static void start() {
        if (started) return;

        started = true;
        if (new SystemProperty().installJansi() && (System.console() != null)) {
            AnsiConsole.systemInstall();
            Runtime.getRuntime().addShutdownHook(new Thread(ConsolePrinter::stop));
        }
    }

    private static void stop() {
        AnsiConsole.systemUninstall();
    }

    public static void print(String text, boolean colored, boolean date, boolean time) {
        System.out.println(getString(text, colored, date, time));
    }

    public static String getString(String text, boolean colorize, boolean date, boolean time) {
        start();

        if (colorize) return colorizer.colorize((date ? util.getDate() : "") + (time ? util.getTime() : "") + text);
        else return (date ? util.getDate() : "") + (time ? util.getTime() : "") + text;
    }

}
