// import java.util.ArrayList;

import bakery.MagicBakery;

// temp
import util.CardUtils;
import bakery.Ingredient;
import bakery.Layer;
import bakery.CustomerOrder;

import java.io.IOException;
import java.util.ArrayList;

public class BakeryDriver {

    public BakeryDriver() {
    }

    public static void main(String[] args) throws IOException {

        MagicBakery magicBakery = new MagicBakery("../../io/ingredients.csv", "../../io/layers.csv");

        ArrayList<Ingredient> ingredients = CardUtils
                .readIngredientFile("io/ingredients.csv");

        ArrayList<Layer> layers = CardUtils
                .readLayerFile("io/layers.csv");

        // ArrayList<CustomerOrder> orders = CardUtils
        // .readCustomerFile("io/customers.csv");
    }

}