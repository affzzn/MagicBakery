package bakery;

/**
 * Exception thrown when the player tries to bake a layer with an invalid
 * recipe.
 * 
 * @author Affan Bin Imran
 * @version "%I%, %G%"
 * 
 */

public class WrongIngredientsException extends java.lang.IllegalArgumentException {

    /**
     * Constructs a WrongIngredientsException with the specified message.
     * 
     * @param msg the message to display
     * 
     */

    public WrongIngredientsException(String msg) {
    }
}
