package pikweb;

import java.util.List;

/**
 * Class representing whole database.
 */
public class PIKdata {

    /**
     * List of all users.
     */
    public List<UserEntity> users;
    /**
     * List of all points.
     */
    public List<PointEntity> points;

    /**
     * Constructor.
     * @param users_ - list of users in the database
     * @param points_ - list of points in the database
     */
    PIKdata(List<UserEntity> users_, List<PointEntity> points_) {
        users = users_;
        points = points_;
    }

}
