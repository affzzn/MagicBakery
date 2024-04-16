package bakery;

import java.io.Serializable;
import java.util.List;

public class Player implements Serializable {

    private List<Ingredient> hand;
    private String name;

    private static final long serialVersionUID = 0;

    public Player(String name) {
        this.name = name;
    }

    public void addToHand(List<Ingredient> ingredients) {

    }

    public void addToHand(Ingredient ingredient) {

    }

    public boolean hasIngredient(Ingredient ingredient) {
        return false;
    }

    public void removeFromHand(Ingredient ingredient) {

    }

    public List<Ingredient> getHand() {
        return hand;
    }

    public String getHandStr() {
        return "";
    }

    public String toString() {
        return "";
    }

}
