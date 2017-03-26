package pikweb;

import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import java.util.Collection;
import java.util.List;

/**
 * Created by Artur on 26.03.2017.
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

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

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
}
