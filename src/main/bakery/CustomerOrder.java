package bakery;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrder {

    private ArrayList<Ingredient> garnish = new ArrayList<Ingredient>();

    private int level;
    private String name;

    private ArrayList<Ingredient> recipe = new ArrayList<Ingredient>();

    private CustomerOrderStatus status; // enum to track order status //

    private static long serialVersionUID;

    public enum CustomerOrderStatus {
        WAITING, // Order is placed and waiting to be processed
        FULFILLED, // Order has been made
        GARNISHED, // Order has been garnished
        IMPATIENT, // Customer is impatient
        GIVEN_UP // Order is abandoned
    }

    public CustomerOrder(String name, ArrayList<Ingredient> recipe, ArrayList<Ingredient> granish, int level) {
        //
        this.name = name;
        this.recipe = recipe;
        this.garnish = granish;
        this.level = level;

        // Add the status attribute to the CustomerOrder class and ensure it is
        // initialised
        // with the correct value in the CustomerOrder constructor.
        this.status = CustomerOrderStatus.WAITING; // default status to WAITING
    }

    public void abandon() {
        this.status = CustomerOrderStatus.GIVEN_UP;
    }

    public boolean canFulfill(List<Ingredient> ingredients) {
        return false;
    }

    public boolean canGarnish(List<Ingredient> ingredients) {
        return false;
    }

    public List<Ingredient> fulfill(List<Ingredient> ingredients, boolean garnish) {
        return null;
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

    // getter and setter for status
    public CustomerOrderStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerOrderStatus status) {
        this.status = status;
    }

    public String toString() {
        return name;
    }
}
