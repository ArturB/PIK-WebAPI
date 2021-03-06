package pikweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * MVC controller class for the whole app. Maps HTTP requests, communicates with database and generate responses.
 */

@RestController
@CrossOrigin
public class RESTController {

    @Autowired
    private HttpSession httpSession;

    /**
     * Add new user to database.
     * @param name Username
     * @param passhash Password hash
     * @return 200 OK and empty body if all right, error status 400 and Exception message in response body otherwise (e.g. username not unique).
     * @throws Exception
     */
    @RequestMapping(value = "/add/user", method = RequestMethod.GET)
    public ResponseEntity<String> addUser(
        @RequestParam(value = "login") String name,
        @RequestParam(value = "passhash") String passhash
    ) throws Exception {
        UserEntity user = new UserEntity();
        user.setLogin(name);
        user.setPasshash(passhash);
        try {
            new Storage().addUser(user);
            return new ResponseEntity<>(
                    HttpStatus.OK.toString(),
                    HttpStatus.OK
            );
        }
        catch(Throwable e) {
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST.value() + ": " + e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    /**
     * Check if user with given username and password exists and set session for him if all right.
     * @param name Username
     * @param passhash Password hash
     * @return 200 OK and logged user object in response body if credentials are valid, error status 400 and empty response body otherwise.
     * @throws Exception
     */
    @RequestMapping(value = "/login/user", method = RequestMethod.GET)
    public ResponseEntity<String> loginUser(
            @RequestParam(value = "login") String name,
            @RequestParam(value = "passhash") String passhash,
            HttpServletRequest request
    ) throws Exception {
        UserEntity user = new UserEntity();
        user.setLogin(name);
        user.setPasshash(passhash);
        try {
            if(new Storage().checkCredentials(user)) {
                try {
                    httpSession.invalidate();
                }
                catch(IllegalStateException e) { }

                httpSession = request.getSession(true);
                httpSession.setAttribute("username", user.getLogin());
                return new ResponseEntity<>(HttpStatus.OK.toString(), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(
                        HttpStatus.BAD_REQUEST.value() + ": "
                                + new InvalidLoginException().getMessage(),
                        HttpStatus.BAD_REQUEST
                );
            }
        }
        catch(Exception e) {
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST.value() + ": " + e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }

    }

    /**
     * Logout user session if it exists.
     * @return 200 OK as confirmation.
     * @throws Exception
     */
    @RequestMapping(value = "/logout/user", method = RequestMethod.GET)
    public ResponseEntity<String> logoutUser(
    ) throws Exception {
        String username = null;
        try {
            username = (String)httpSession.getAttribute("username");
            httpSession.invalidate();
        }
        catch(IllegalStateException e) { }
        return new ResponseEntity<>(username + ", " + HttpStatus.OK.toString(), HttpStatus.OK);
    }

    /**
     * Delete user from database if only given password is valid.
     * @param name Username of user to delete.
     * @param passhash Password hash.
     * @return 200 OK and empty response body if credentials are valid, error status 400 and Exception message otherwise.
     * @throws Exception
     */
    @RequestMapping(value = "/delete/user", method = RequestMethod.GET)
    public ResponseEntity<String> deleteUser(
            @RequestParam(value = "login") String name,
            @RequestParam(value = "passhash") String passhash
    ) throws Exception {
        UserEntity user = new UserEntity();
        user.setLogin(name);
        user.setPasshash(passhash);
        try {
            new Storage().deleteUser(user);
            return new ResponseEntity<>(HttpStatus.OK.toString(), HttpStatus.OK);
        }
        catch(Throwable e) {
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST.value() + ": " + e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    /**
     * Return all points of logged user.
     * @return List of points of logged user.
     * @throws Exception
     */
    @RequestMapping(value = "/get/user/points", method = RequestMethod.GET)
    public List<PointEntity> userPoints(
            @RequestParam(value = "login") String name
    ) throws Exception {
        List<PointEntity> points = null;
        //String userName;
        try {
            //userName = (String)httpSession.getAttribute("username");
            points = new Storage().getUserPoints(name);
        }
        catch(UserNotLoggedException e) {}

        return points;
    }

    /**
     * Add new point to logged user.
     * @return 200 if OK, 400 and exception message if not OK
     * @throws Exception
     */
    @RequestMapping(value = "/add/user/points", method = RequestMethod.GET)
    public ResponseEntity<String> addUserPoints(
            @RequestParam(value = "longitude") double pLongitude,
            @RequestParam(value = "latitude") double pLatitude,
            @RequestParam(value = "name") String pName


    ) throws Exception {

        PointEntity point = new PointEntity();
        point.setLatitude(pLatitude);
        point.setLongitude(pLongitude);
        point.setName(pName);
        String uLogin = (String)httpSession.getAttribute("username");
        if (uLogin == null)
        {
            throw new UserNotLoggedException();
        }
        UserEntity uE = new Storage().getUserByLogin(uLogin);
        point.setUserByOwner(uE);
        try {
            new Storage().addPoint(point);
            return new ResponseEntity<>(
                    HttpStatus.OK.toString(),
                    HttpStatus.OK
            );
        }
         catch(Throwable e) {
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST.value() + ": " + e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }

    }

    /**
     * Delete point of logged user.
     * @return 200 if OK, 400 and exception message if not OK
     * @throws Exception
     */
    @RequestMapping(value = "/delete/user/points", method = RequestMethod.GET)
    public ResponseEntity<String> deleteUserPoints(
            @RequestParam(value = "id") int pId

    ) throws Exception {
        PointEntity point = new PointEntity();
        UserEntity user = new UserEntity();
        point.setId(pId);
        String uLogin = (String)httpSession.getAttribute("username");
        if (uLogin == null)
        {
            throw new UserNotLoggedException();
        }
        else
            user.setLogin(uLogin);
        try {
            new Storage().deletePoint(point, user);
            return new ResponseEntity<>(HttpStatus.OK.toString(), HttpStatus.OK);
        }
        catch(Throwable e) {
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST.value() + ": " + e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }

    }

    /**
     * Get list of all users points in databse.
     * @return All points in database.
     * @throws Exception
     */
    @RequestMapping(value = "/get/points", method = RequestMethod.GET)
    public List<PointEntity> getPoints(

    ) throws Exception {
        List<PointEntity> points = new Storage().getAllPoints();
        return points;

    }


}
