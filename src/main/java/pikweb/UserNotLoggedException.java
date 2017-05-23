package pikweb;

/**
 * Created by Julita Ołtusek on 17.05.2017.
 */
public class UserNotLoggedException extends Exception {

    /**
     * Get message override
     * @return Message of exception: "Invalid username or password!"
     */
    public String getMessage() {
        return "No user logged!";
    }
}
