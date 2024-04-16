package bakery;

public class Ingredient {
    private String name;

    public static Ingredient HELPFUL_DUCK;
    private static long serialVersionUID;

    public Ingredient(String name) {
        this.name = name; //
    }

    public boolean equals(Object o) {
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return name;
    }
}
