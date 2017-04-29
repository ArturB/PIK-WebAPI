package pikweb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * MVC controller class for the whole app. Maps HTTP requests, communicates with database and generate responses.
 */

@RestController
public class RESTController {

    /**
     * Add new user to database.
     * @param name Username
     * @param passhash Password hash
     * @return 200 OK and empty body if all right, error status 465 and Exception message in response body otherwise (e.g. username not unique).
     * @throws Exception
     */
    @RequestMapping(value = "/add/user", method = RequestMethod.GET)
    public String addUser(
        @RequestParam(value = "login", required = true) String name,
        @RequestParam(value = "passhash", required = true) String passhash
    ) throws Exception {

        return "";
    }

    /**
     * Check if user with given username and password exists and set session for him if all right.
     * @param name Username
     * @param passhash Password hash
     * @return 200 OK and logged user object in response body if credentials are valid, error status 466 and empty response body otherwise.
     * @throws Exception
     */
    @RequestMapping(value = "/login/user", method = RequestMethod.GET)
    public UserEntity loginUser(
            @RequestParam(value = "login", required = true) String name,
            @RequestParam(value = "passhash", required = true) String passhash
    ) throws Exception {

        return new UserEntity();

    }

    /**
     * Logout user session if it exists.
     * @param name Login of user to logout
     * @return 200 OK as confirmation.
     * @throws Exception
     */
    @RequestMapping(value = "/logout/user", method = RequestMethod.GET)
    public String logoutUser(
            @RequestParam(value = "login", required = true) String name
    ) throws Exception {

        return "";

    }

    /**
     * Delete user from database if only given password is valid.
     * @param name Username of user to delete.
     * @param passhash Password hash.
     * @return 200 OK and empty response body if credentials are valid, error status 467 and Exception message otherwise.
     * @throws Exception
     */
    @RequestMapping(value = "/delete/user", method = RequestMethod.GET)
    public String deleteUser(
            @RequestParam(value = "login", required = true) String name,
            @RequestParam(value = "passhash", required = true) String passhash
    ) throws Exception {

        return "";

    }

    /**
     * Return all points of logged user.
     * TODO: by Julita Ołtusek
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/get/user/points", method = RequestMethod.GET)
    public List<PointEntity> userPoints(

    ) throws Exception {

        return new ArrayList<PointEntity>();

    }

    /**
     * Add new point to logged user.
     * TODO: by Julita Ołtusek
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add/user/points", method = RequestMethod.GET)
    public String addUserPoints(

    ) throws Exception {

        return "";

    }

    /**
     * Delete point of logged user.
     * TODO: by Julita Ołtusek
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete/user/points", method = RequestMethod.GET)
    public String deleteUserPoints(

    ) throws Exception {

        return "";

    }

    /**
     * Get list of all users points in databse.
     * TODO: by Julita Ołtusek.
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/get/points", method = RequestMethod.GET)
    public List<PointEntity> getPoints(

    ) throws Exception {

        return new ArrayList<PointEntity>();

    }


    /*@RequestMapping(value = "/HomeController", method = RequestMethod.GET)
    public PIKdata getPoints() throws Exception {

        PIKdata result = new Storage().getAllData();
        Hibernate.initialize(result);
        return result;
        //return "HomeController";

    }
    */
}
