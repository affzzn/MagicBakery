package bakery;

import java.util.ArrayList;

public class Player {

    private ArrayList<Ingredient> hand;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void addToHand(ArrayList<Ingredient> ingredients) {

    }

    public void addToHand(Ingredient ingredient) {

    }

    public boolean hasIngredient(Ingredient ingredient) {
        return false;
    }

    public void removeFromHand(Ingredient ingredient) {

    }

    public ArrayList<Ingredient> getHand() {
        return hand;
    }

    public String getHandStr() {
        return "";
    }

    public String toString() {
        return "";
    }

}
