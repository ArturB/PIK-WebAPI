package pikweb;

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

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "text/plain")
    public String getPoints() throws Exception {
        Storage st = new Storage();
        List<PointEntity> ls = st.getAllPoints();
        Gson g = new Gson();
        return g.toJson(ls);
    }

}
