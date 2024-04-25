package bakery;

/**
 * Exception thrown when the player tries to perform too many actions in a turn.
 * 
 * @author Affan Bin Imran
 * @version "%I%, %G%"
 */

public class TooManyActionsException extends java.lang.IllegalStateException {

    /**
     * Constructs a TooManyActionsException with the specified message.
     */
    public TooManyActionsException() {
    }
}