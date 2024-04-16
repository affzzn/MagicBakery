package bakery;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import bakery.CustomerOrder.CustomerOrderStatus;

public class Customers {

    private Collection<CustomerOrder> activeCustomers;
    private Collection<CustomerOrder> customerDeck;

    private List<CustomerOrder> inactiveCustomers;

    private Random random;

    private static long serialVersionUID;

    public Customers(String deckFile, Random random, Collection<Layer> layers, int numPlayers) {
        this.random = random;
    }

    public CustomerOrder addCustomerOrder() {
        return null;
    }

    public boolean customerWillLeaveSoon() {
        return false;
    }

    public CustomerOrder drawCustomer() {
        return null;
    }

    public Collection<CustomerOrder> getActiveCustomers() {
        return activeCustomers;
    }

    public Collection<CustomerOrder> getCustomerDeck() {
        return customerDeck;
    }

    public Collection<CustomerOrder> getFulfillable(List<Ingredient> hand) {
        return null;
    }

    public Collection<CustomerOrder> getInactiveCustomersWithStatus(CustomerOrderStatus status) {
        return inactiveCustomers;
    }

    private void initialiseCustomerDeck(String deckFile) {

    }

    public boolean isEmpty() {
        return false;
    }

    public CustomerOrder peek() {
        return null;
    }

    public void removeCustomer(CustomerOrder customer) {

    }

    public int size() {
        return 0;
    }

    public CustomerOrder timePasses() {
        return null;
    }
}
