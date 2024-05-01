package bakery;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import bakery.CustomerOrder.CustomerOrderStatus;

/**
 * Represents the customers in the bakery.
 * The customers are divided into active customers, customer deck, and inactive
 * customers.
 * 
 * @author Affan Bin Imran
 * 
 * @version "%I%, %G%"
 */

public class Customers implements Serializable {

    private Collection<CustomerOrder> activeCustomers;
    private Collection<CustomerOrder> customerDeck;

    private List<CustomerOrder> inactiveCustomers;

    private Random random;

    private static final long serialVersionUID = 0;

    //
    private ArrayList<CustomerOrder> tempOrders = new ArrayList<>();

    /**
     * Constructs a Customers object with the specified deck file, random number
     * generator, layers, and number of players.
     * 
     * @param deckFile   the file containing the customer orders
     * @param random     the random number generator
     * @param layers     the layers in the game
     * @param numPlayers the number of players in the game
     * @throws FileNotFoundException if the file does not exist
     * @throws IOException           if an I/O error occurs
     */
    public Customers(
            String deckFile, Random random,
            Collection<Layer> layers,
            int numPlayers) throws FileNotFoundException, IOException {

        this.random = random;
        this.activeCustomers = new ArrayList<>();
        this.customerDeck = new Stack<>();
        this.inactiveCustomers = new ArrayList<>();

        initialiseCustomerDeck(deckFile, layers, numPlayers);
    }

    /**
     * Adds a customer order to the active customers.
     * 
     * @return the customer order
     */

    public CustomerOrder addCustomerOrder() {
        return null;
    }

    /**
     * Adds a customer order to the inactive customers.
     * 
     * @return boolean value customer will leave soon
     */

    public boolean customerWillLeaveSoon() {
        return false;
    }

    /**
     * Draws a customer from the customer deck.
     * 
     * @return the customer order
     */

    public CustomerOrder drawCustomer() {
        return null;
    }

    /**
     * Returns the active customers.
     * 
     * @return the active customers
     */

    public Collection<CustomerOrder> getActiveCustomers() {
        return activeCustomers;
    }

    /**
     * Returns the customer deck.
     * 
     * @return the customer deck
     */
    public Collection<CustomerOrder> getCustomerDeck() {
        return customerDeck;
    }

    /**
     * Returns the inactive customers.
     * 
     * @param hand the player's hand
     * @return the inactive customers
     */
    public Collection<CustomerOrder> getFulfillable(List<Ingredient> hand) {
        return null;
    }

    /**
     * Returns the inactive customers.
     * 
     * @param status the status of the customers
     * @return the inactive customers
     */

    public Collection<CustomerOrder> getInactiveCustomersWithStatus(CustomerOrderStatus status) {
        return inactiveCustomers;
    }

    private void initialiseCustomerDeck(String deckFile, Collection<Layer> layers, int numPlayers)
            throws FileNotFoundException, IOException {

        File file = new File(deckFile);

        if (!file.exists()) {
            throw new FileNotFoundException("File does not exist: ");
        }

        this.customerDeck.clear();
        this.tempOrders.clear();

        ArrayList<CustomerOrder> fileList = new ArrayList<CustomerOrder>(
                util.CardUtils.readCustomerFile(deckFile, layers));

        Collections.shuffle(fileList, random);

        ArrayList<CustomerOrder> level1 = new ArrayList<>();
        ArrayList<CustomerOrder> level2 = new ArrayList<>();
        ArrayList<CustomerOrder> level3 = new ArrayList<>();

        for (int i = 0; i < fileList.size(); i++) {
            switch (fileList.get(i).getLevel()) {
                case 1:
                    level1.add(fileList.get(i));
                    break;
                case 2:
                    level2.add(fileList.get(i));
                    break;
                case 3:
                    level3.add(fileList.get(i));
                    break;
            }
        }

        switch (numPlayers) {
            case 2:
                for (int i = 0; i < 4; i++) {
                    tempOrders.add(level1.get(i));
                }
                for (int i = 0; i < 2; i++) {
                    tempOrders.add(level2.get(i));
                }
                for (int i = 0; i < 1; i++) {
                    tempOrders.add(level3.get(i));
                }
                break;
            case 3:
            case 4:
                for (int i = 0; i < 1; i++) {
                    tempOrders.add(level1.get(i));
                }
                for (int i = 0; i < 2; i++) {
                    tempOrders.add(level2.get(i));
                }
                for (int i = 0; i < 4; i++) {
                    tempOrders.add(level3.get(i));
                }
                break;
            case 5:
                for (int i = 0; i < 1; i++) {
                    tempOrders.add(level2.get(i));
                }
                for (int i = 0; i < 6; i++) {
                    tempOrders.add(level3.get(i));
                }
                break;
        }

        Collections.shuffle(tempOrders, random);

        this.customerDeck = tempOrders;

    }

    /**
     * Returns true if the customer deck is empty.
     * 
     * @return true if the customer deck is empty, false otherwise
     */

    public boolean isEmpty() {
        for (int i = 0; i < this.activeCustomers.size(); i++) {
            if (((List<CustomerOrder>) activeCustomers).get(i) != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the next customer in the customer deck.
     * 
     * @return the next customer in the customer deck
     */

    public CustomerOrder peek() {
        return null;
    }

    /**
     * Removes a customer order from the active customers.
     * 
     * @param customer the customer order to remove
     */

    public void remove(CustomerOrder customer) {

    }

    /**
     * Removes a customer order from the customer deck.
     * 
     * @return size of the customer deck
     */

    public int size() {
        return 0;
    }

    /**
     * Simulates the passage of time for the customers.
     * 
     * @return CustomerOrder object
     */

    public CustomerOrder timePasses() {
        return null;
    }
}
