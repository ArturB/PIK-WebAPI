package pikweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import java.util.*;
import com.google.gson.*;


/**
 * Created by Artur on 25.03.2017.
 */

@Controller
public class HomeController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getPoints() throws Exception {
        Storage st = new Storage();
        List<PointEntity> ls = st.getAllPoints();
        Gson g = new Gson();
        return g.toJson(ls);
    }

}
