package bakery;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Layer in the Magic Bakery game.
 * Each Layer has a name and a recipe containing ingredients.
 * 
 * @author Affan Bin Imran
 * @version "%I%, %G%"
 */

public class Layer extends Ingredient {

    private List<Ingredient> recipe;

    private static final long serialVersionUID = 0;

    /**
     * Constructs a layer with the specified name and recipe.
     *
     * @param name   the name of the layer
     * @param recipe the recipe of the layer
     * @throws WrongIngredientsException if the recipe is null or empty
     */

    public Layer(String name, List<Ingredient> recipe) throws WrongIngredientsException {
        super(name);

        if (recipe == null) {
            throw new WrongIngredientsException("Recipe cannot be empty");
        } else if (recipe.size() == 0) {
            throw new WrongIngredientsException("Recipe cannot be null");
        } else {
            this.recipe = recipe;
        }

    }

    /**
     * Checks if the player's hand contains a specific ingredient.
     *
     * @param ingredients the list of ingredients to check
     * @return true if the player's hand contains the ingredient, false otherwise
     */

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

    /**
     * Returns the recipe of the layer.
     *
     * @return the recipe of the layer
     */

    public List<Ingredient> getRecipe() {
        return recipe;
    }

    /**
     * Returns the description of the recipe of the layer.
     *
     * @return the description of the recipe of the layer
     */

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

    /**
     * Returns a string representation of the layer.
     *
     * @return a string representation of the layer
     */

    // structural test :: hashCode :: dont see this method in the UML

    /**
     * Returns a hash code value for the object.
     * 
     * @return a hash code value for this object
     */
    public int hashCode() {
        return super.hashCode();
    }
}