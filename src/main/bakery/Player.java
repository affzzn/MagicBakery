package bakery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Player implements Serializable {

    private List<Ingredient> hand;
    private String name;

    private static final long serialVersionUID = 0;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void addToHand(List<Ingredient> ingredients) {
        // hand.addAll(ingredients);
        for (int i = 0; i < ingredients.size(); i++) {
            hand.add(ingredients.get(i));
        }
    }

    public void addToHand(Ingredient ingredient) {
        hand.add(ingredient);
    }

    public boolean hasIngredient(Ingredient ingredient) {
        return hand.contains(ingredient);
    }

    public void removeFromHand(Ingredient ingredient) {
        hand.remove(ingredient);
    }

    public List<Ingredient> getHand() {
        // return hand;
        Collections.sort(hand);
        return new ArrayList<>(hand);
    }

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

        for (int i = 0; i < ingredientKey.size(); i++) {
            if (i > 0) {
                handString.append(", ");
            }
            Ingredient key = ingredientKey.get(i);
            handString.append(key.toString());
            int frequency = ingredientMap.get(key);

            if (frequency > 1) {
                handString.append(" (x").append(frequency).append(")");
            }
        }

        return handString.toString();
    }

    public String toString() {
        return name;
    }

}
