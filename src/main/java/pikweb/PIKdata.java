package pikweb;
import org.springframework.security.core.userdetails.User;

import java.util.*;

/**
 * Created by Artur on 11.04.2017.
 */
public class PIKdata {
    public List<UserEntity> users;
    public List<PointEntity> points;

    PIKdata(List<UserEntity> users_, List<PointEntity> points_) {
        users = users_;
        points = points_;
    }

}
