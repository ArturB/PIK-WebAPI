package pikweb;

/**
 * Exception thrown in {@link pikweb.Storage} class
 */
public class InvalidIdException extends Exception {
    /**
     * Get message override
     * @return Message of exception: "Invalid  point id!"
     */
    public String getMessage() {
        return "Invalid point or it doesn't belong to logged user!";
    }
}
