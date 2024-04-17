package bakery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
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
        StringBuilder handStr = new StringBuilder();
        for (int i = 0; i < hand.size(); i++) {
            handStr.append(hand.get(i)).append(", ");
        }

        if (handStr.length() > 0) {
            return handStr.substring(0, handStr.length() - 2);
        } else {
            return "";
        }
    }

    public String toString() {
        return name;
    }

}
