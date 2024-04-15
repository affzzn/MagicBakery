package util;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;

public class ConsoleUtils {

    private Console console;

    public ConsoleUtils() {
        console = System.console();
    }

    public String readLine() {
        return "";
    }

    public String readLine(String fmt, Object... args) {
        return "";
    }

    public File promptForFilePath(String prompt) {
        return null;
    }

    public ArrayList<String> promptForNewPlayers(String prompt) {
        return null;
    }

    public boolean promptForStartLoad(String prompt) {
        return false;
    }

    public boolean promptForYesNo(String prompt) {
        return false;
    }
}
