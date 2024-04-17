package bakery;

import java.io.Serializable;

public class Ingredient implements Serializable, Comparable<Ingredient> {
    private String name;

    public static final Ingredient HELPFUL_DUCK = new Ingredient("helpful duck");
    private static final long serialVersionUID = 0;

    public Ingredient(String name) {
        this.name = name; //
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        } else if (o.getClass().equals(this.getClass()) && o.toString().equals(this.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return name;
    }

    public int compareTo(Ingredient o) {
        // return this.name.compareTo(o.name);
        return 0;
    }
}
