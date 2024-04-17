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
        for (Ingredient requiredIngredient : recipe) {
            boolean ingredientFound = false;
            for (Ingredient ingredient : ingredients) {
                if (ingredient.equals(requiredIngredient)) {
                    ingredientFound = true;
                    break;
                }
            }
            if (!ingredientFound && !requiredIngredient.equals(Ingredient.HELPFUL_DUCK)) {
                // If any required ingredient is not found in the provided list, return false
                return false;
            }
        }
        // If all required ingredients are found in the provided list, return true
        return true;
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
