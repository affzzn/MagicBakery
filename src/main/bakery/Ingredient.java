package bakery;

import java.io.Serializable;

/**
 * Represents an Ingredient in the Magic Bakery game.
 * Each Ingredient has a name.
 * 
 * @author Affan Bin Imran
 * @version "%I%, %G%"
 */

public class Ingredient implements Serializable, Comparable<Ingredient> {
    private String name;

    /**
     * Represents a helpful duck in the Magic Bakery game.
     */

    public static final Ingredient HELPFUL_DUCK = new Ingredient("helpful duck 𓅭");
    private static final long serialVersionUID = 0;

    /**
     * Constructs an ingredient with the specified name.
     *
     * @param name the name of the ingredient
     */

    public Ingredient(String name) {
        this.name = name;
    }

    /**
     * Return true if the object is an Ingredient with the same name as this
     * Ingredient.
     * 
     * @param o the object to compare
     * @return true if the object is an Ingredient with the same name as this
     *         Ingredient, false otherwise
     */

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        } else if (o.getClass().equals(this.getClass()) && o.toString().equals(this.toString())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the hash code of the Ingredient.
     * 
     * @return the hash code of the Ingredient
     */

    public int hashCode() {
        return this.name.hashCode();
    }

    /**
     * Returns the name of the Ingredient.
     * 
     * @return the name of the Ingredient
     */

    public String toString() {
        return name;
    }

    /**
     * Compares this Ingredient to another Ingredient.
     * 
     * @param o the Ingredient to compare
     * @return a negative integer, zero, or a positive integer as this Ingredient is
     *         less than, equal to, or greater than the specified Ingredient
     */

    public int compareTo(Ingredient o) {
        return this.name.compareTo(o.name);
    }
}
