package util;

import java.io.Console;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bakery.CustomerOrder;
import bakery.Ingredient;
import bakery.MagicBakery;
import bakery.MagicBakery.ActionType;
import bakery.Player;

/**
 * Utility class for console input/output.
 * This class provides methods for reading input from the console and displaying
 * 
 * @author Affan Bin Imran
 * @version "%I%, %G%"
 * 
 */

public class ConsoleUtils {

    private Console console;

    /**
     * Constructs a new ConsoleUtils object.
     */

    public ConsoleUtils() {
        console = System.console();
    }

    /**
     * Reads a line of text from the console.
     * 
     * @return the line of text read from the console
     */

    public String readLine() {
        return console.readLine();
    }

    /**
     * Reads a line of text from the console using the specified format string and
     * arguments.
     * 
     * @param fmt  the format string
     * @param args the arguments referenced by the format specifiers in the format
     *             string
     * @return the line of text read from the console
     */

    public String readLine(String fmt, Object... args) {
        return console.readLine(fmt, args);
    }

    /**
     * Displays the specified message on the console.
     * 
     * @param prompt the message to display
     * @param bakery the MagicBakery object
     * 
     * @return the ActionType selected by the player
     */
    public ActionType promptForAction(String prompt, MagicBakery bakery) {
        return null;
    }

    /**
     * Displays the specified message on the console and prompts the player to
     * select an action.
     * 
     * @param prompt    the message to display
     * @param customers the collection of customers to choose from
     * 
     * @return customerOrder the customer selected by the player
     */

    public CustomerOrder promptForCustomer(String prompt, Collection<CustomerOrder> customers) {
        return null;
    }

    /**
     * Displays the specified message on the console and prompts the player to
     * 
     * @param prompt for an existing player.
     * @param bakery the MagicBakery object
     * @return the player selected by the user
     */

    public Player promptForExistingPlayer(String prompt, MagicBakery bakery) {
        return null;
    }

    /**
     * Displays the specified message on the console and prompts the player to
     * select an ingredient.
     * 
     * @param prompt the message to display
     * 
     * @return the ingredient selected by the player
     */

    public File promptForFilePath(String prompt) {

        String path = console.readLine(prompt);
        File fileObj = new File(path);

        return fileObj;
    }

    /**
     * Displays the specified message on the console and prompts the player to
     * select an ingredient.
     * 
     * @param prompt      the message to display
     * @param ingredients the collection of ingredients to choose from
     * 
     * @return the ingredient selected by the player
     */

    public Ingredient promptForIngredient(String prompt, Collection<Ingredient> ingredients) {

        System.out.println(prompt);

        // String selectedIngredient = console.readLine("Enter ingredient:");
        // if (ingredients.containsAll(selectedIngredient)) {
        // return new Ingredient(selectedIngredient);
        // }

        return null;
    }

    /**
     * Displays the specified message on the console and prompts the player to
     * select a player.
     * 
     * @param prompt the message to display
     * 
     * @return the player selected by the player
     */

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

    /**
     * Displays the specified message on the console and prompts the player to
     * select a player.
     * 
     * @param prompt the message to display
     * 
     * @return the player selected by the player
     */

    public boolean promptForStartLoad(String prompt) {
        return console.readLine(prompt).equalsIgnoreCase("yes");
    }

    /**
     * Displays the specified message on the console and prompts the player to
     * select a player.
     * 
     * @param prompt the message to display
     * 
     * 
     * @return the player selected by the player
     */

    public boolean promptForYesNo(String prompt) {
        return console.readLine(prompt).equalsIgnoreCase("yes");
    }

    private Object promptEnumerateCollection(String prompt, Collection<Object> collection)
            throws InvocationTargetException {
        if (collection == null) {

            throw new InvocationTargetException(new NullPointerException());
        } else {

            return null;
        }
    }
}
