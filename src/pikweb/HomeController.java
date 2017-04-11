package pikweb;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.*;
import com.google.gson.*;


/**
 * Created by Artur on 25.03.2017.
 */

@RestController
public class HomeController {

    @RequestMapping(value = "/HomeController", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String getPoints() throws Exception {
        /*Storage st = new Storage();
        Gson g = new Gson();
        return g.toJson(new Storage().getAllData());*/
        return "HomeController";
    }

}
