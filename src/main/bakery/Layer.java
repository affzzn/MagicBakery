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
        for (int i = 0; i < recipe.size(); i++) {
            Ingredient requiredIngredient = recipe.get(i);
            boolean ingredientFound = false;
            for (int j = 0; j < ingredients.size(); j++) {
                Ingredient ingredient = ingredients.get(j);
                if (requiredIngredient.equals(ingredient) || requiredIngredient.equals(Ingredient.HELPFUL_DUCK)) {
                    ingredientFound = true;
                    break;
                }
            }
            // If the required ingredient or a Helpful Duck substitute is not found, return
            // false
            if (!ingredientFound) {
                return false;
            }
        }
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

    // structural test :: hashCode :: dont see this method in the UML
    public int hashCode() {
        return super.hashCode();
    }
}
