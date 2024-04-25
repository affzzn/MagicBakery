package bakery;

/**
 * Exception thrown when the pantry is empty.
 * 
 * @author Affan Bin Imran
 * @version "%I%, %G%"
 */

public class EmptyPantryException extends java.lang.RuntimeException {

    /**
     * Constructs an EmptyPantryException with the specified message.
     * 
     * @param msg the message to display
     * @param e   the exception that caused this exception
     * 
     */
    public EmptyPantryException(String msg, Throwable e) {
        super(msg, e);
    }
}
