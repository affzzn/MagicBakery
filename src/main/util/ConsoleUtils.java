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

        System.out.println(prompt);

        // String selectedIngredient = console.readLine("Enter ingredient:");
        // if (ingredients.containsAll(selectedIngredient)) {
        // return new Ingredient(selectedIngredient);
        // }

        return null;
    }

    public List<String> promptForNewPlayers(String prompt) {
        System.out.println(prompt);

        ArrayList<String> players = new ArrayList<>();

        int minPlayers = 2;
        int maxPlayers = 5;

        while ((players.size() < minPlayers) || (players.size() > maxPlayers)) {
            String playerName = console.readLine("Enter Player name: ");
            playerName = playerName.trim();

            boolean nameExists = false;
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).equalsIgnoreCase(playerName)) {
                    nameExists = true;
                    break;
                }
            }

            if (nameExists) {
                System.out.println("Player name already exists. Please enter a different name.");
                continue;
            }

            players.add(playerName);

            if ((players.size() < minPlayers) || (players.size() > maxPlayers)) {
                System.out.println("You can only enter 2 - 5 players");
            }

            if ((players.size() < maxPlayers) && (players.size() >= minPlayers)) {

                boolean choice = promptForYesNo("Do You want to add another player? (yes/no): ");
                if (choice == false) {
                    break;
                }
            }
        }

        return players;
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
