package bakery;

import java.util.ArrayList;
import java.util.List;

public class Layer extends Ingredient {

    private List<Ingredient> recipe;

    private static final long serialVersionUID = 0;

    public Layer(String name, List<Ingredient> recipe) {
        super(name);
        this.recipe = recipe;
    }

    public boolean canBake(List<Ingredient> ingredients) {
        return false;
    }

    public List<Ingredient> getRecipe() {
        return recipe;
    }

    public String getRecipeDescription() {
        // return recipe.toString(); //

        StringBuilder recipeDescription = new StringBuilder();
        for (Ingredient ingredient : recipe) {
            recipeDescription.append(ingredient).append(", ");
        }

        // return recipeDescription.toString().trim().substring(0, 0); // trim to remove
        // the trailing space

        return recipeDescription.toString().substring(0, recipeDescription.toString().length() - 2);

    }

    // just to pass the structural test :: hashCode :: dont see this method in the
    // UML
    public int hashCode() {
        return super.hashCode();
    }
}
