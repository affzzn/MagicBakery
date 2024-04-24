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

    //
    private Player currentPlayer;
    //
    private int actionsRemaining;

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
        if (this.pantryDeck.isEmpty()) {
            if (this.pantryDiscard.isEmpty()) {
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
        // itertare through pantry: if name of pantry ingredient is == ingredient name
        // (remove
        // it from the pantry), add it to current players hand, and break

        // also decrease actions count

        for (int i = 0; i < pantry.size(); i++) {
            if (((ArrayList<Ingredient>) pantry).get(i).toString().equals(IngredientName)) {
                currentPlayer.addToHand(((ArrayList<Ingredient>) pantry).get(i));
                pantry.remove(((ArrayList<Ingredient>) pantry).get(i));
                break;
            }
        }
        actionsRemaining--;

    }

    public void drawFromPantry(Ingredient ingredient) {
        // iterate through pantry: if pantry ingredient == ingredient (remove
        // it from the pantry), add it to current players hand, and break

        // also decrease actions count

        for (int i = 0; i < pantry.size(); i++) {
            if (((ArrayList<Ingredient>) pantry).get(i).equals(ingredient)) {
                currentPlayer.addToHand(((ArrayList<Ingredient>) pantry).get(i));
                pantry.remove(((ArrayList<Ingredient>) pantry).get(i));
                break;
            }
        }
        actionsRemaining--;

    }

    public boolean endTurn() {

        currentPlayer = ((ArrayList<Player>) players)
                .get((((ArrayList<Player>) players).indexOf(currentPlayer) + 1) % players.size());

        // reset action remaining
        actionsRemaining = getActionsPermitted();

        // if cureent player = palayers.get(0) >>> if customer deck for customers is not
        // empty add a cust order
        // else call time passes ::

        // need to implement timepasses and addCustomerOrder for it to work ::

        // if (currentPlayer == ((ArrayList<Player>) players).get(0)) {
        // if (customers.getCustomerDeck().isEmpty()) {
        // customers.addCustomerOrder();
        // } else {
        // customers.timePasses();
        // }
        // }

        return false;
    }

    public List<Ingredient> fulfillOrder(CustomerOrder customer, boolean garnish) {
        return null;
    }

    public int getActionsPermitted() {
        int numPlayers = players.size();
        if (numPlayers == 2 || numPlayers == 3) {
            return 3;
        }
        return 2;
    }

    public int getActionsRemaining() {
        return actionsRemaining;
    }

    public Collection<Layer> getBakeableLayers() {
        return null;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
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
        if (actionsRemaining <= 0) {
            throw new TooManyActionsException();
        }
        // if said ingredient is not in users hand, worng ingredient exception

        actionsRemaining--;

    }

    public void printCustomerServiceRecord() {

    }

    public void printGameState() {

    }

    public void refreshPantry() {
        if (actionsRemaining <= 0) {
            throw new TooManyActionsException();
        }
        pantryDiscard.addAll(pantry);
        pantry.clear();
        pantry.add(drawFromPantryDeck());
        pantry.add(drawFromPantryDeck());
        pantry.add(drawFromPantryDeck());
        pantry.add(drawFromPantryDeck());
        pantry.add(drawFromPantryDeck());

        actionsRemaining--;
    }

    public void saveState(File file) {

    }

    public void startGame(List<String> playerNames, String customerDeckFile) throws FileNotFoundException {

        // Initialize players
        players = new ArrayList<Player>();

        for (int i = 0; i < playerNames.size(); i++) {
            players.add(new Player(playerNames.get(i)));
        }

        currentPlayer = ((ArrayList<Player>) players).get(0);

        actionsRemaining = getActionsPermitted();

        // Initialize customers
        this.customers = new Customers(customerDeckFile, this.random, this.layers,
                playerNames.size());

        // Initialize pantry - shuffle the pantry deck
        Collections.shuffle((List<?>) this.pantryDeck, this.random); //

        // Draw customer orders

        int numOrders = 0;
        if ((playerNames.size() == 3) || (playerNames.size() == 5)) {
            numOrders = 2;
        } else {
            numOrders = 1;
        }

        // initialize the customer orders and then draw them ??

        // for (int i = 0; i < numOrders; i++) {
        // this.customers.addCustomerOrder();
        // }

        // Deal 3 cards to each player from the pantry deck
        for (int i = 0; i < this.players.size(); i++) {
            Player player = ((ArrayList<Player>) this.players).get(i);
            // Each player draws 3 cards from pantryDeck
            for (int j = 0; j < 3; j++) {
                Ingredient card = ((Stack<Ingredient>) this.pantryDeck).pop();
                player.addToHand(card);
            }
        }

    }

}