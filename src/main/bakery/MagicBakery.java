package bakery;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import util.CardUtils;

public class MagicBakery implements Serializable {

    private Customers customers;

    private Collection<Layer> layers;

    private Collection<Player> players;

    private Collection<Ingredient> pantry;

    private Collection<Ingredient> pantryDeck;

    private Collection<Ingredient> pantryDiscard;

    private Random random;

    private static final long serialVersionUID = 0;

    // enum: ActionType
    public enum ActionType {
        DRAW_INGREDIENT, PASS_INGREDIENT, BAKE_LAYER, FULFIL_ORDER, REFRESH_PANTRY
    }

    public MagicBakery(long seed, String ingredientDeckFile, String layerDeckFile) throws IOException {

        random = new Random(seed);

        pantry = new ArrayList<Ingredient>();
        players = new ArrayList<Player>();
        pantryDeck = new Stack<Ingredient>(); // LIFO
        pantryDiscard = new Stack<Ingredient>(); // LIFO // ?????????
        layers = new ArrayList<Layer>();

        List<Ingredient> lstIng = new ArrayList<Ingredient>(CardUtils.readIngredientFile(ingredientDeckFile));
        for (Ingredient i : lstIng) {
            pantryDeck.add(i);
        }

        List<Layer> lstLayer = new ArrayList<Layer>(CardUtils.readLayerFile(layerDeckFile));
        for (Layer i : lstLayer) {
            layers.add(i);
        }

    }

    public void bakeLayer(Layer layer) {

    }

    private Ingredient drawFromPantryDeck() {
        if (pantryDeck.isEmpty()) {
            if (pantryDiscard.isEmpty()) {
                throw new EmptyPantryException("empty...", new RuntimeException("Pantry is empty!"));
            }
            pantryDeck.addAll(pantryDiscard);
            pantryDiscard.clear();

            // shuffle the pantry deck again
            Collections.shuffle((List<?>) pantryDeck, this.random);
        }
        return ((Stack<Ingredient>) pantryDeck).pop();

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

    public int getActionsRemaining() {
        return 0;
    }

    public Collection<Layer> getBakeableLayers() {
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
        // return customers.getFulfillableOrders(pantry);

    }

    public Collection<CustomerOrder> getGarnishableCustomers() {
        return null;
    }

    public Collection<Layer> getLayers() {
        return this.layers;
    }

    public Collection<Ingredient> getPantry() {
        return this.pantry;
    }

    public Collection<Player> getPlayers() {
        return this.players;
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
        pantryDiscard.addAll(pantry);
        pantry.clear();
        pantry.add(drawFromPantryDeck());
        pantry.add(drawFromPantryDeck());
        pantry.add(drawFromPantryDeck());
        pantry.add(drawFromPantryDeck());
        pantry.add(drawFromPantryDeck());
    }

    public void saveState(File file) {

    }

    public void startGame(List<String> playerNames, String customerDeckFile) throws FileNotFoundException {

        // // Initialize players
        // players = new ArrayList<Player>();

        // for (int i = 0; i < playerNames.size(); i++) {
        // players.add(new Player(playerNames.get(i)));
        // }

        // // Initialize customers
        // this.customers = new Customers(customerDeckFile, this.random, this.layers,
        // playerNames.size());

        // // Initialize pantry - shuffle the pantry deck
        // Collections.shuffle((List<?>) this.pantryDeck, this.random); //

        // // Draw customer orders

        // int numOrders = 0;
        // if ((playerNames.size() == 3) || (playerNames.size() == 5)) {
        // numOrders = 2;
        // } else {
        // numOrders = 1;
        // }

        // // initialize the customer orders and then draw them ??

        // for (int i = 0; i < numOrders; i++) {
        // this.customers.addCustomerOrder();
        // }

        // // Deal 3 cards to each player from the pantry deck
        // for (int i = 0; i < this.players.size(); i++) {
        // Player player = ((ArrayList<Player>) this.players).get(i);
        // // Each player draws 3 cards from pantryDeck
        // for (int j = 0; j < 3; j++) {
        // Ingredient card = ((Stack<Ingredient>) this.pantryDeck).pop();
        // player.addToHand(card);
        // }
        // }

    }

}