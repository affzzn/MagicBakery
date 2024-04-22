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
        int helpfulDuckCount = 0;
        int missingIngredients = 0;

        // Count the number of helpful ducks in the ingredients list
        for (int i = 0; i < ingredients.size(); i++) {
            if (ingredients.get(i).equals(Ingredient.HELPFUL_DUCK)) {
                helpfulDuckCount++;
            }
        }

        // create a copy of ingredients list
        ArrayList<Ingredient> copy = new ArrayList<Ingredient>(ingredients);

        // Check each ingredient required in the recipe
        for (int i = 0; i < recipe.size(); i++) {

            if (copy.contains(recipe.get(i))) {
                copy.remove(recipe.get(i));
            }

            else {
                missingIngredients++;
            }
        }

        // Check if the number of helpful ducks can cover the missing ingredients
        return missingIngredients == 0 || missingIngredients <= helpfulDuckCount;
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