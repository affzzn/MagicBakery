package bakery;

import java.util.ArrayList;

public class MagicBakery {

    // missing params: // long seed, String ingredientDeckFile, String layerDeckFile

    public MagicBakery(String ingredientDeckFile, String layerDeckFile) {
        Ingredient flour = new Ingredient("Flour");
        Ingredient sugar = new Ingredient("Sugar");
        Ingredient egg = new Ingredient("Egg");
        Ingredient milk = new Ingredient("Milk");
        Ingredient butter = new Ingredient("Butter");
        Ingredient vanilla = new Ingredient("Vanilla");
        Ingredient bakingPowder = new Ingredient("Baking Powder");
        Ingredient salt = new Ingredient("Salt");

        ArrayList<Ingredient> recipe = new ArrayList<Ingredient>();
        recipe.add(flour);
        recipe.add(sugar);
        recipe.add(egg);
        recipe.add(milk);
        recipe.add(butter);
        recipe.add(vanilla);
        recipe.add(bakingPowder);
        recipe.add(salt);

        Layer cakeLayer = new Layer("Cake Layer", recipe);

        System.out.println(cakeLayer.getRecipeDescription());

        //
        ArrayList<Ingredient> garnish = new ArrayList<Ingredient>();
        garnish.add(flour);
        garnish.add(sugar);
        garnish.add(egg);

        CustomerOrder cake = new CustomerOrder("Cake", recipe, garnish, 1);

        // ArrayList<Ingredient> allIngredients =
        // CardUtils.readIngredientFile(ingredientDeckFile);

        // System.out.println(allIngredients.size());

    }

    public void startGame(String customerDeckFile) {
        // constructor
    }

}
