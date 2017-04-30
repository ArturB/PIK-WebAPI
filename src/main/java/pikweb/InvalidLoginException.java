package pikweb;

/**
 * Exception thrown in {@link pikweb.Storage} class
 */
public class InvalidLoginException extends Exception {

    /**
     * Get message override
     * @return Message of exception: "Invalid username or password!"
     */
    public String getMessage() {
        return "Invalid username or password!";
    }
}
