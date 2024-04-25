package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bakery.CustomerOrder;
import bakery.Ingredient;
import bakery.Layer;

/**
 * Utility class for reading ingredients, layers, and customer orders from
 * files.
 * 
 * @author Affan Bin Imran
 * 
 * @version "%I%, %G%"
 */

public class CardUtils {

    // all methods are static

    private CardUtils() {
    }

    // read ingredients from a file

    /**
     * Reads ingredients from a file and returns a list of ingredients.
     * 
     * @param path
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     */

    public static List<Ingredient> readIngredientFile(String path) throws IOException, FileNotFoundException {
        // stringToIngredient is supposed to read the ingredients file line by line and
        // calls the stringToIngredient method for each line

        if (path == null) {
            throw new FileNotFoundException("Path cannot be null");
        } else {

            ArrayList<Ingredient> allIngredients = new ArrayList<>(); // big list of all ingredients

            BufferedReader reader = null;
            String line = "";

            try {
                reader = new BufferedReader(new FileReader(path));

                line = reader.readLine(); // skip the header
                while ((line = reader.readLine()) != null) {
                    stringToIngredients(line); // not sure
                    allIngredients.addAll(stringToIngredients(line));
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                throw e;
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(allIngredients.size());
            System.out.println(allIngredients.toString());
            return allIngredients;
        }
    }

    private static List<Ingredient> stringToIngredients(String str) {
        // implement the logic to convert a string (file data) into
        // a list of Ingredients

        System.out.println(str);

        // split the string by comma
        String[] parts = str.split(",");
        String name = parts[0].trim();
        // int quantity = Integer.parseInt(parts[1]); // idk

        int quantity = 0;
        try {
            quantity = Integer.parseInt(parts[1].trim());
        } catch (NumberFormatException e) {
            // Handle the case where the quantity is not a valid integer
            System.err.println("Invalid quantity: " + parts[1].trim());
            e.printStackTrace();
            return new ArrayList<>(); // Return an empty list
        }

        // create new ArrayList of Ingredients

        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

        // create a new Ingredient object

        for (int i = 0; i < quantity; i++) {
            Ingredient newIngredient = new Ingredient(name);
            ingredients.add(newIngredient);
        }

        return ingredients;
    }

    /**
     * Reads ingredients from a file and returns a list of ingredients.
     * 
     * 
     * @param path
     * @return a list of layers
     * @throws IOException
     */

    public static List<Layer> readLayerFile(String path) throws IOException {
        ArrayList<Layer> allLayers = new ArrayList<Layer>(); // big list of all layers

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine(); // Skip the header
            while ((line = reader.readLine()) != null) {
                // stringToLayers(line); // im not sure about this
                allLayers.addAll(stringToLayers(line));
            }
        }

        System.out.println(allLayers.size());
        System.out.println(allLayers.toString());
        return allLayers;
    }

    private static List<Layer> stringToLayers(String str) {
        System.out.println(str);

        // split the string by comma
        String[] parts = str.split(",");
        String name = parts[0].trim();
        String recipeString = parts[1].trim();

        // Parse the recipe string
        String[] ingredientNames = recipeString.split(";");

        // Create a new ArrayList to hold the ingredients for this layer
        ArrayList<Ingredient> recipeIngredients = new ArrayList<>();

        // Create Ingredient objects for each ingredient name
        for (int i = 0; i < ingredientNames.length; i++) {
            String ingredientName = ingredientNames[i].trim();
            Ingredient ingredient = new Ingredient(ingredientName);
            recipeIngredients.add(ingredient);
        }

        // Create an ArrayList to hold the layers
        ArrayList<Layer> layers = new ArrayList<>();

        // Create four copies of the layer
        for (int i = 0; i < 4; i++) {
            // Create a new Layer object with the parsed data
            Layer layer = new Layer(name, recipeIngredients);
            layers.add(layer);
        }

        return layers;
    }

    // customer orrders

    /**
     * Reads customer orders from a file and returns a list of customer orders.
     * 
     * @param path
     * @param layers
     * @return
     * @throws IOException
     */

    public static List<CustomerOrder> readCustomerFile(String path, Collection<Layer> layers)
            throws IOException {

        ArrayList<CustomerOrder> allOrders = new ArrayList<CustomerOrder>(); // big list of all orders

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine(); // Skip the header
            while ((line = reader.readLine()) != null) {
                allOrders.add(stringToCustomerOrder(line, layers));
                // stringToCustomerOrder(line, layers));
            }
        }

        System.out.println(allOrders.size());
        System.out.println(allOrders.toString());
        return allOrders;
    }

    private static CustomerOrder stringToCustomerOrder(String str, Collection<Layer> layers) {
        System.out.println(str);

        // split the string by comma
        String[] parts = str.split(",");
        int level = Integer.parseInt(parts[0].trim());
        String name = parts[1].trim();
        String recipeString = parts[2].trim();

        // Create a new ArrayList to hold the ingredients for this layer
        ArrayList<Ingredient> recipeIngredients = new ArrayList<>();
        ArrayList<Ingredient> garnishIngredients = new ArrayList<>();

        if (parts.length > 3) {
            String garnishString = parts[3].trim();
            String[] garnishNames = garnishString.split(";");
            // Create Ingredient objects for each garnish name //
            for (int i = 0; i < garnishNames.length; i++) {
                boolean found = false;
                String garnishName = garnishNames[i].trim();
                for (int j = 0; j < layers.size(); j++) {
                    if (garnishName.equals(((List<Layer>) layers).get(j).toString())) {
                        garnishIngredients.add(((List<Layer>) layers).get(j));
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    Ingredient garnish = new Ingredient(garnishName);
                    garnishIngredients.add(garnish);
                }
            }
        }

        // Parse the recipe string
        String[] ingredientNames = recipeString.split(";");

        // Create Ingredient objects for each ingredient name
        for (int i = 0; i < ingredientNames.length; i++) {
            String ingredientName = ingredientNames[i].trim();
            boolean found = false;
            for (int j = 0; j < layers.size(); j++) {
                if (ingredientName.equals(((List<Layer>) layers).get(j).toString())) {
                    recipeIngredients.add(((List<Layer>) layers).get(j));
                    found = true;
                    break;
                }
            }
            if (!found) {
                Ingredient ingredient = new Ingredient(ingredientName);
                recipeIngredients.add(ingredient);
            }
        }

        // Create an ArrayList to hold the orders
        // ArrayList<CustomerOrder> orders = new ArrayList<>();

        // Create a new Layer object with the parsed data
        CustomerOrder order = new CustomerOrder(name, recipeIngredients, garnishIngredients, level);
        // orders.add(order);

        return order;
    }

}