package util;

import java.io.Console;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bakery.CustomerOrder;
import bakery.Ingredient;
import bakery.MagicBakery;
import bakery.MagicBakery.ActionType;
import bakery.Player;

public class ConsoleUtils {

    private Console console;

    public ConsoleUtils() {
        console = System.console();
        // this.console = console; //
    }

    public String readLine() {
        return console.readLine();
    }

    public String readLine(String fmt, Object... args) {
        return console.readLine(fmt, args);
    }

    public ActionType promptForAction(String prompt, MagicBakery bakery) {
        return null;
    }

    public CustomerOrder promptForCustomer(String prompt, Collection<CustomerOrder> customers) {
        return null;
    }

    public Player promptForExistingPlayer(String prompt, MagicBakery bakery) {
        return null;
    }

    public File promptForFilePath(String prompt) {

        String path = console.readLine(prompt);
        File fileObj = new File(path);

        return fileObj;
    }

    public Ingredient promptForIngredient(String prompt, Collection<Ingredient> ingredients) {
        return null;
    }

    public List<String> promptForNewPlayers(String prompt) {

        System.out.println(prompt);

        ArrayList<String> players = new ArrayList<String>();

        int minPlayers = 2;
        int maxPlayers = 5;

        int curPlayers = 0;

        while (curPlayers < minPlayers || curPlayers > maxPlayers) {
            players.add(console.readLine("Enter Player name: "));

            curPlayers = players.size();

            if (curPlayers < minPlayers || curPlayers > maxPlayers) {
                System.out.println("You can only enter 2 - 5 players");
            }

            if ((curPlayers < maxPlayers) && (curPlayers >= minPlayers)) {
                promptForYesNo("Do You want to add another player? (yes/no): ");
                String choice = console.readLine().trim().toLowerCase();
                if (!choice.equals("yes")) {
                    break;
                }
            }
        }

        return players;

        // returning null for structural tests // temp
        // return null;
    }

    public boolean promptForStartLoad(String prompt) {
        return console.readLine(prompt).equalsIgnoreCase("yes");
    }

    public boolean promptForYesNo(String prompt) {
        return console.readLine(prompt).equalsIgnoreCase("yes");
    }

    private Object promptEnumerateCollection(String prompt, Collection<Object> collection) {
        return null;
    }
}