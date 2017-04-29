package pikweb;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * DAO object. Allows to work with the database.
 */
public class Storage {
    private static final SessionFactory ourSessionFactory;

    //create static session on start
    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Get a database session.
     * @return Current database connection session.
     * @throws HibernateException
     */
    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }



    /**
     * Get list of all points in the database.
     * @return List of all points in the database.
     * @throws Exception
     */
    public List<PointEntity> getAllPoints() throws Exception {
        final Session session = getSession();
        try {
            final Query query = session.createQuery("from " + "PointEntity");
            List<PointEntity> ls = query.list();
            return ls;
        } finally {
            session.close();
        }
    }

    /**
     * Get list of all users in the database.
     * @return List of all users in the database.
     * @throws Exception
     */
    public List<UserEntity> getAllUsers() throws Exception {
        final Session session = getSession();
        try {
            final Query query = session.createQuery("from " + "UserEntity");
            List<UserEntity> ls = query.list();
            return ls;
        } finally {
            session.close();
        }
    }

    /**
     * Get whole database from server - all points and all users.
     * @return Whole databse data - all points and all users.
     * @throws Exception
     */
    public PIKdata getAllData() throws Exception {
        return new PIKdata(getAllUsers(), getAllPoints());
    }
}
