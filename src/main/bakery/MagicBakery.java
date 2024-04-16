package bakery;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class MagicBakery {

    // missing params: // long seed, String ingredientDeckFile, String layerDeckFile

    // structural code

    private Customers customer;

    private Collection<Layer> layers;

    private Collection<Player> players;

    private Collection<Ingredient> pantry;

    private Collection<Ingredient> pantryDeck;

    private Collection<Ingredient> pantryDiscard;

    private Random random;

    private static long serialVersionUID;

    // enum: ActionType
    public enum ActionType {
        DRAW_INGREDIENT, PASS_INGREDIENT, BAKE_LAYER, FULFIL_ORDER, REFRESH_PANTRY
    }

    public MagicBakery(String ingredientDeckFile, String layerDeckFile) {

        // Ingredient flour = new Ingredient("Flour");
        // Ingredient sugar = new Ingredient("Sugar");
        // Ingredient egg = new Ingredient("Egg");
        // Ingredient milk = new Ingredient("Milk");
        // Ingredient butter = new Ingredient("Butter");
        // Ingredient vanilla = new Ingredient("Vanilla");
        // Ingredient bakingPowder = new Ingredient("Baking Powder");
        // Ingredient salt = new Ingredient("Salt");

        // ArrayList<Ingredient> recipe = new ArrayList<Ingredient>();
        // recipe.add(flour);
        // recipe.add(sugar);
        // recipe.add(egg);
        // recipe.add(milk);
        // recipe.add(butter);
        // recipe.add(vanilla);
        // recipe.add(bakingPowder);
        // recipe.add(salt);

        // Layer cakeLayer = new Layer("Cake Layer", recipe);

        // System.out.println(cakeLayer.getRecipeDescription());

        // //
        // ArrayList<Ingredient> garnish = new ArrayList<Ingredient>();
        // garnish.add(flour);
        // garnish.add(sugar);
        // garnish.add(egg);

        // CustomerOrder cake = new CustomerOrder("Cake", recipe, garnish, 1);

        // ArrayList<Ingredient> allIngredients =
        // CardUtils.readIngredientFile(ingredientDeckFile);

        // System.out.println(allIngredients.size());

    }

    public void bakeLayer(Layer layer) {

    }

    private Ingredient drawFromPantryDeck() {
        return null;
    }

    public void drawFromPantry(String IngredientName) {

    }

    public void drawFromPantry(Ingredient ingredient) {

    }

    public boolean endTurn() {
        return false;
    }

    public List<Ingredient> fulfillOrder(CustomerOrder customer, boolean garnish) {
        return null;
    }

    public int getActionsPermitted() {
        return 0;
    }

    public int getActionRemaining() {
        return 0;
    }

    public Collection<Layer> getBakabLayers() {
        return null;
    }

    public Player getCurrentPlayer() {
        return null;
    }

    public Customers getCustomers() {
        return null;
    }

    public Collection<CustomerOrder> getFulfilableCustomers() {
        return null;
    }

    public Collection<CustomerOrder> getGarnsihableCustomers() {
        return null;
    }

    public Collection<Layer> getLayers() {
        return null;
    }

    public Collection<Ingredient> getPantry() {
        return null;
    }

    public Collection<Player> getPlayers() {
        return null;
    }

    public static MagicBakery loadState(File file) {
        return null;
    }

    public void passCard(Ingredient ingredient, Player recipient) {

    }

    public void printCustomerServiceRecord() {

    }

    public void printGameState() {

    }

    public void refreshPantry() {

    }

    public void saveState(File file) {

    }

    public void startGame(ArrayList<String> playerNames, String customerDeckFile) {

    }

}
