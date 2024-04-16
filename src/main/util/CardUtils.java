package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import bakery.CustomerOrder;
import bakery.Ingredient;
import bakery.Layer;

public class CardUtils {

    // all methods are static

    private CardUtils() {
    }

    // read ingredients from a file
    public static ArrayList<Ingredient> readIngredientFile(String path) throws IOException {
        // stringToIngredient is supposed to read the ingredients file line by line and
        // calls the stringToIngredient method for each line

        ArrayList<Ingredient> allIngredients = new ArrayList<>(); // big list of all ingredients

        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(path));

            line = reader.readLine(); // skip the header
            while ((line = reader.readLine()) != null) {
                stringToIngredients(line); // im not sure ahout this
                allIngredients.addAll(stringToIngredients(line));
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // For now, I'll return an empty Arraylist
        // return new ArrayList<Ingredient>();

        // real return
        System.out.println(allIngredients.size());
        System.out.println(allIngredients.toString());
        return allIngredients;
    }

    private static ArrayList<Ingredient> stringToIngredients(String str) {
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

    // Layers

    // Read layers from a file
    public static ArrayList<Layer> readLayerFile(String path) throws IOException {
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

    private static ArrayList<Layer> stringToLayers(String str) {
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

    public static ArrayList<CustomerOrder> readCustomerFile(String path, ArrayList<Layer> layers)
            throws IOException {
        ArrayList<CustomerOrder> allOrders = new ArrayList<CustomerOrder>(); // big list of all orders

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine(); // Skip the header
            while ((line = reader.readLine()) != null) {
                // stringToOrders(line); // im not sure about this
                allOrders.addAll(stringToCustomerOrder(line, layers));
            }
        }

        System.out.println(allOrders.size());
        System.out.println(allOrders.toString());
        return allOrders;
    }

    private static ArrayList<CustomerOrder> stringToCustomerOrder(String str, ArrayList<Layer> layers) {
        System.out.println(str);

        // split the string by comma
        String[] parts = str.split(",");
        int level = Integer.parseInt(parts[0].trim());
        String name = parts[1].trim();
        String recipeString = parts[2].trim();
        String garnishString = parts[3].trim();

        // Parse the recipe string
        String[] ingredientNames = recipeString.split(";");
        String[] garnishNames = garnishString.split(";");

        // Create a new ArrayList to hold the ingredients for this layer
        ArrayList<Ingredient> recipeIngredients = new ArrayList<>();
        ArrayList<Ingredient> garnishIngredients = new ArrayList<>();

        // Create Ingredient objects for each ingredient name
        for (int i = 0; i < ingredientNames.length; i++) {
            String ingredientName = ingredientNames[i].trim();
            Ingredient ingredient = new Ingredient(ingredientName);
            recipeIngredients.add(ingredient);
        }

        // Create Ingredient objects for each garnish name //
        for (int i = 0; i < garnishNames.length; i++) {
            String garnishName = garnishNames[i].trim();
            Ingredient garnish = new Ingredient(garnishName);
            garnishIngredients.add(garnish);
        }

        // Create an ArrayList to hold the orders
        ArrayList<CustomerOrder> orders = new ArrayList<>();

        // Create a new Layer object with the parsed data
        CustomerOrder order = new CustomerOrder(name, recipeIngredients, garnishIngredients, level);
        orders.add(order);

        return orders;
    }

}