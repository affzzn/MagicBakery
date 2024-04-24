package bakery;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer order in the bakery.
 * Each order has a name, recipe, garnish, level, and status.
 */

public class CustomerOrder implements java.io.Serializable {

    private List<Ingredient> garnish;

    private int level;
    private String name;

    private List<Ingredient> recipe;

    private CustomerOrderStatus status; // enum to track order status //

    private static final long serialVersionUID = 0;

    /**
     * Enum to track the status of a customer order.
     */
    public enum CustomerOrderStatus {
        WAITING, // Order is placed and waiting to be processed
        FULFILLED, // Order has been made
        GARNISHED, // Order has been garnished
        IMPATIENT, // Customer is impatient
        GIVEN_UP // Order is abandoned
    }

    /**
     * Constructs a customer order with the specified name, recipe, garnish, and
     * level.
     *
     * @param name    the name of the customer order
     * @param recipe  the recipe of the customer order
     * @param garnish the garnish of the customer order
     * @param level   the level of the customer order
     */

    public CustomerOrder(String name, List<Ingredient> recipe, List<Ingredient> granish, int level)
            throws WrongIngredientsException {

        if (recipe == null) {
            throw new WrongIngredientsException("Recipe cannot be null");
        } else if (recipe.size() == 0) {
            throw new WrongIngredientsException("Recipe cannot be empty");
        } else {
            this.recipe = recipe;
        }

        if (granish == null) {
            throw new WrongIngredientsException("Garnish cannot be null");
        } else {
            this.garnish = granish;
        }

        this.name = name;
        this.level = level;

        this.status = CustomerOrderStatus.WAITING; // default status to WAITING
    }

    /**
     * Abandons the customer order by setting its status to GIVEN_UP.
     */

    public void abandon() {
        // this.status = CustomerOrderStatus.GIVEN_UP;
        setStatus(CustomerOrderStatus.GIVEN_UP);

    }

    /**
     * Checks if the customer order can be fulfilled with the given ingredients.
     *
     * @param ingredients the ingredients to check against the recipe
     * @return true if the order can be fulfilled, false otherwise
     */

    public boolean canFulfill(List<Ingredient> ingredients) {
        int helpfulDuckCount = 0;
        int missingIngredients = 0;

        // check for if the ingredient is an instance of Layer

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
                if ((recipe.get(i) instanceof Layer)) {
                    return false;
                }
                missingIngredients++;

            }
        }
        return missingIngredients == 0 || missingIngredients <= helpfulDuckCount;
    }

    /**
     * Checks if the customer order can be garnished with the given ingredients.
     *
     * @param ingredients the ingredients to check against the garnish
     * @return true if the order can be garnished, false otherwise
     */

    public boolean canGarnish(List<Ingredient> ingredients) {
        int helpfulDuckCount = 0;
        int missingIngredients = 0;

        // check for if the ingredient is an instance of Layer

        // Count the number of helpful ducks in the ingredients list
        for (int i = 0; i < ingredients.size(); i++) {
            if (ingredients.get(i).equals(Ingredient.HELPFUL_DUCK)) {
                helpfulDuckCount++;
            }
        }
        // create a copy of ingredients list
        ArrayList<Ingredient> copy = new ArrayList<Ingredient>(ingredients);

        // Check each ingredient required in the recipe
        for (int i = 0; i < garnish.size(); i++) {

            if (copy.contains(garnish.get(i))) {
                copy.remove(garnish.get(i));
            }

            else {
                if ((garnish.get(i) instanceof Layer)) {
                    return false;
                }
                missingIngredients++;

            }
        }
        return missingIngredients == 0 || missingIngredients <= helpfulDuckCount;
    }

    /**
     * Fulfills the customer order with the given ingredients.
     *
     * @param ingredients the ingredients used to fulfill the order
     * @param garnish     true if the order should be garnished, false otherwise
     * @return the list of ingredients used to fulfill the order
     */

    public List<Ingredient> fulfill(List<Ingredient> ingredients, boolean garnish) throws WrongIngredientsException {

        ArrayList<Ingredient> usedIngredients = new ArrayList<Ingredient>();

        if (canFulfill(ingredients)) {
            setStatus(CustomerOrderStatus.FULFILLED);

            ArrayList<Ingredient> copy = new ArrayList<Ingredient>(ingredients);

            for (int i = 0; i < this.recipe.size(); i++) {
                if (copy.contains(this.recipe.get(i))) {
                    copy.remove(this.recipe.get(i));
                } else {
                    copy.remove(Ingredient.HELPFUL_DUCK);
                }
            }

            if (garnish && canGarnish(copy) && !this.garnish.isEmpty()) {
                setStatus(CustomerOrderStatus.GARNISHED);
                for (int i = 0; i < this.garnish.size(); i++) {
                    copy.remove(this.garnish.get(i));
                    if (copy.contains(this.garnish.get(i))) {
                        copy.remove(this.garnish.get(i));
                    } else {
                        copy.remove(Ingredient.HELPFUL_DUCK);
                    }
                }
            }

            for (int j = 0; j < ingredients.size(); j++) {
                if (!copy.contains(ingredients.get(j))) {
                    usedIngredients.add(ingredients.get(j));
                }
            }
        }
        return usedIngredients;
    }

    /**
     * Returns a string representation of the garnish.
     *
     * @return a string representing the garnish
     */

    public List<Ingredient> getGarnish() {
        return garnish;
    }

    public String getGarnishDescription() {
        if (garnish.isEmpty()) {
            return "";
        }
        StringBuilder garnishDescription = new StringBuilder();
        for (Ingredient ingredient : garnish) {
            garnishDescription.append(ingredient).append(", ");
        }
        return garnishDescription.toString().substring(0, garnishDescription.toString().length() - 2);
    }

    public int getLevel() {
        return level;
    }

    public List<Ingredient> getRecipe() {
        return recipe;
    }

    /**
     * Returns a string representation of the recipe.
     *
     * @return a string representing the recipe
     */
    public String getRecipeDescription() {
        if (recipe.isEmpty()) {
            return "";
        }
        StringBuilder recipeDescription = new StringBuilder();
        for (Ingredient ingredient : recipe) {
            recipeDescription.append(ingredient).append(", ");
        }
        return recipeDescription.toString().substring(0, recipeDescription.toString().length() - 2);
    }

    // getter and setter for status
    public CustomerOrderStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerOrderStatus status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the customer order.
     *
     * @return the name of the customer order
     */
    public String toString() {
        return name;
    }
}
