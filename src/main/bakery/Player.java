package bakery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import util.StringUtils;

/**
 * Represents a player in the Magic Bakery game.
 * Each player has a name and a hand containing ingredients.
 * 
 * @author Affan Bin Imran
 * @version "%I%, %G%"
 */
public class Player implements Serializable {

    private List<Ingredient> hand;
    private String name;

    private static final long serialVersionUID = 0;

    /**
     * Constructs a player with the specified name.
     *
     * @param name the name of the player
     */

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    /**
     * Adds a list of ingredients to the player's hand.
     *
     * @param ingredients the list of ingredients to add to the hand
     */

    public void addToHand(List<Ingredient> ingredients) {
        // hand.addAll(ingredients);
        for (int i = 0; i < ingredients.size(); i++) {
            hand.add(ingredients.get(i));
        }
    }

    /**
     * Adds an ingredient to the player's hand.
     *
     * @param ingredient the ingredient to add to the hand
     */

    public void addToHand(Ingredient ingredient) {
        hand.add(ingredient);
    }

    /**
     * Checks if the player's hand contains a specific ingredient.
     *
     * @param ingredient the ingredient to check
     * @return true if the hand contains the ingredient, false otherwise
     */

    public boolean hasIngredient(Ingredient ingredient) {
        return hand.contains(ingredient);
    }

    /**
     * Removes an ingredient from the player's hand.
     *
     * @param ingredient the ingredient to remove
     * @throws WrongIngredientsException if the ingredient is not found in the hand
     */

    public void removeFromHand(Ingredient ingredient) throws WrongIngredientsException {
        if (!hand.contains(ingredient)) {
            throw new WrongIngredientsException("Ingredient not found in hand");
        } else {
            int count = 0;
            for (Ingredient h : hand) {
                if (h == ingredient) {
                    count++;
                }
            }
            if (count == 1) {

                hand.remove(ingredient);
            } else {
                hand.remove(ingredient);
            }
        }
    }

    /**
     * Retrieves a sorted list of ingredients in the player's hand.
     *
     * @return a sorted list of ingredients in the hand
     */

    public List<Ingredient> getHand() {
        // return hand;
        // Collections.sort(hand);
        // return new ArrayList<>(hand);

        this.hand.sort(null);
        return this.hand;
    }

    /**
     * Retrieves a string representation of the player's hand.
     * Ingredients are sorted and grouped by their frequency in the hand.
     *
     * @return a string representation of the hand
     */

    public String getHandStr() {
        if (hand.isEmpty()) {
            return "";
        }

        Collections.sort(hand);

        StringBuilder handString = new StringBuilder();
        HashMap<Ingredient, Integer> ingredientMap = new HashMap<>();

        for (int i = 0; i < hand.size(); i++) {
            Ingredient ingredient = hand.get(i);
            ingredientMap.put(ingredient, ingredientMap.getOrDefault(ingredient, 0) + 1);
        }

        ArrayList<Ingredient> ingredientKey = new ArrayList<>(ingredientMap.keySet());
        ingredientKey.sort(null);

        for (int i = 0; i < ingredientKey.size(); i++) {
            if (i > 0) {
                handString.append(", ");
            }
            Ingredient key = ingredientKey.get(i);
            handString.append(StringUtils.toTitleCase(key.toString()));
            int frequency = ingredientMap.get(key);

            if (frequency > 1) {
                handString.append(" (x").append(frequency).append(")");
            }
        }

        return handString.toString();
    }

    /**
     * Returns the name of the player.
     *
     * @return the name of the player
     */

    public String toString() {
        return name;
    }

}
