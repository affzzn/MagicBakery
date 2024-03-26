package bakery;

import java.util.ArrayList;

public class CustomerOrder {

    private ArrayList<Ingredient> garnish = new ArrayList<Ingredient>();

    private int level;
    private String name;

    private ArrayList<Ingredient> recipe = new ArrayList<Ingredient>();

    public CustomerOrder(String name, ArrayList<Ingredient> recipe, ArrayList<Ingredient> granish, int level) {
        //
        this.name = name;
        this.recipe = recipe;
        this.garnish = granish;
        this.level = level;
    }

    public ArrayList<Ingredient> getGarnish() {
        return garnish;
    }

    public String getGarnishDescription() {
        StringBuilder garnishDescription = new StringBuilder();
        for (Ingredient ingredient : garnish) {
            garnishDescription.append(ingredient).append(" ");
        }
        return garnishDescription.toString().trim();
    }

    public int getLevel() {
        return level;
    }

    public ArrayList<Ingredient> getRecipe() {
        return recipe;
    }

    public String getRecipeDescription() {
        StringBuilder recipeDescription = new StringBuilder();
        for (Ingredient ingredient : recipe) {
            recipeDescription.append(ingredient).append(" ");
        }
        return recipeDescription.toString().trim();
    }

    public String toString() {
        return name;
    }
}
