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

/**
 * Represents the Magic Bakery game.
 * 
 * 
 * @author Affan Bin Imran
 * 
 * @version "%I%, %G%"
 */

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

    /**
     * Constructs a MagicBakery object with the specified seed, ingredient deck
     * file,
     * and layer deck file.
     * 
     */

    // enum: ActionType
    public enum ActionType {
        DRAW_INGREDIENT, PASS_INGREDIENT, BAKE_LAYER, FULFIL_ORDER, REFRESH_PANTRY
    }

    /**
     * Constructs a MagicBakery object with the specified seed, ingredient deck
     * file, and layer deck file.
     * 
     * @param seed
     * @param ingredientDeckFile
     * @param layerDeckFile
     * @throws IOException
     * @throws FileNotFoundException
     */

    public MagicBakery(long seed, String ingredientDeckFile, String layerDeckFile)
            throws IOException, FileNotFoundException {

        if (ingredientDeckFile.isEmpty()) {
            throw new FileNotFoundException();
        }

        if (layerDeckFile.isEmpty()) {
            throw new FileNotFoundException();
        }

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

    /**
     * Bakes the specified layer.
     * 
     * @param layer
     */

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

    /**
     * Draws an ingredient from the pantry deck and adds it to the current player's
     * hand.
     * 
     * @param the name of the ingredient to draw
     * @throws TooManyActionsException if the player has no actions remaining
     */

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

    /**
     * Draws an ingredient from the pantry deck and adds it to the current player's
     * hand.
     * 
     * @param ingredient
     */

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

    /**
     * Ends the current player's turn.
     * 
     * @return true if the game is over, false otherwise
     */

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

    /**
     * Fulfills the specified customer order.
     * 
     * @param customer the customer order to fulfill
     * @param garnish  true if the order should be garnished, false otherwise
     * @return the list of ingredients used to fulfill the order
     */

    public List<Ingredient> fulfillOrder(CustomerOrder customer, boolean garnish) {
        return null;
    }

    /**
     * Returns the number of actions permitted for the current player.
     * 
     * @return the number of actions permitted for the current player
     */

    public int getActionsPermitted() {
        int numPlayers = players.size();
        if (numPlayers == 2 || numPlayers == 3) {
            return 3;
        }
        return 2;
    }

    /**
     * Returns the number of actions remaining for the current player.
     * 
     * @return the number of actions remaining for the current player
     */

    public int getActionsRemaining() {
        return actionsRemaining;
    }

    /**
     * Returns the bakeable layers.
     * 
     * @return the bakeable layers
     */

    public Collection<Layer> getBakeableLayers() {
        return null;
    }

    /**
     * Returns the current player.
     * 
     * @return the current player
     */

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Returns the customer service record.
     * 
     * @return the customer service record
     */

    public Customers getCustomers() {
        return null;
    }

    /**
     * Returns the customers that can be fulfilled.
     * 
     * @return the customers that can be fulfilled
     */

    public Collection<CustomerOrder> getFulfilableCustomers() {
        return null;
        // return customers.getFulfillableOrders(pantry);

    }

    /**
     * Returns the garnishable customers.
     * 
     * @return the garnishable customers
     */

    public Collection<CustomerOrder> getGarnishableCustomers() {
        return null;
    }

    /**
     * Returns the layers.
     * 
     * @return the layers
     */

    public Collection<Layer> getLayers() {
        return this.layers;
    }

    /**
     * Returns the pantry.
     * 
     * @return the pantry
     */

    public Collection<Ingredient> getPantry() {
        return this.pantry;
    }

    /**
     * Returns the pantry deck.
     * 
     * @return the pantry deck
     */

    public Collection<Player> getPlayers() {
        return this.players;
    }

    /**
     * Returns the random number generator.
     * 
     * @return the random number generator
     * 
     * 
     * @throws FileNotFoundException if the file is null
     */

    public static MagicBakery loadState(File file) throws FileNotFoundException {

        if (file == null) {
            throw new FileNotFoundException();
        }

        return null;
    }

    /**
     * Passes the specified ingredient to the specified player.
     * 
     * @param ingredient the ingredient to pass
     * @param recipient  the player to pass the ingredient to
     * @throws WrongIngredientsException if the ingredient is not in the current
     *                                   player's hand
     * 
     */

    public void passCard(Ingredient ingredient, Player recipient) throws WrongIngredientsException {
        if (actionsRemaining <= 0) {
            throw new TooManyActionsException();
        }
        // if said ingredient is not in users hand, worng ingredient exception
        if (!currentPlayer.getHand().contains(ingredient)) {
            throw new WrongIngredientsException("ingredient not found");
        }

        actionsRemaining--;

    }

    /**
     * Passes the specified ingredient to the specified player.
     * 
     * @param ingredient the ingredient to pass
     * @param recipient  the player to pass the ingredient to
     * @throws WrongIngredientsException if the ingredient is not in the current
     *                                   player's hand
     * @throws TooManyActionsException   if the player has no actions remaining
     */

    public void printCustomerServiceRecord() {

    }

    /**
     * Prints the game state.
     */

    public void printGameState() {

    }

    /**
     * Refreshes the pantry.
     * 
     * @throws TooManyActionsException if the player has no actions remaining
     */

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

    /**
     * Saves the game state to the specified file.
     * 
     * @param file the file to save the game state to
     * @throws FileNotFoundException if the file is null
     */

    public void saveState(File file) throws FileNotFoundException {
        if (file == null) {
            throw new FileNotFoundException();
        }

    }

    /**
     * Sets the current player.
     * 
     * @param player the player to set as the current player
     */

    public void startGame(List<String> playerNames, String customerDeckFile) throws FileNotFoundException, IOException {

        if (customerDeckFile.isEmpty()) {
            throw new FileNotFoundException();
        }

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