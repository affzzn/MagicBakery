package bakery;

import java.util.ArrayList;

public class Layer extends Ingredient {

    private ArrayList<Ingredient> recipe = new ArrayList<Ingredient>();

    public Layer(String name, ArrayList<Ingredient> recipe) {
        super(name);
        this.recipe = recipe;
    }

    public ArrayList<Ingredient> getRecipe() {
        return recipe; //
    }

    public String getRecipeDescription() {
        // return recipe.toString(); //

        StringBuilder recipeDescription = new StringBuilder();
        for (Ingredient ingredient : recipe) {
            recipeDescription.append(ingredient).append(" ");
        }
        return recipeDescription.toString().trim(); // trim to remove the trailing space

        // int i = 0;
        // while (i < recipe.size()) {
        // System.out.print(recipe.get(i) + " ");
        // i++;
        // }
        // return "";

        // for (int i = 0; i < recipe.size(); i++) {
        // // System.out.print(recipe.get(i) + " ");
        // return recipe.get(i) + " ";
        // }
        // return "";
    }
}
