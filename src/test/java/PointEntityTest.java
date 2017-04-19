package test.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import pikweb.PointEntity;
import pikweb.UserEntity;

import java.io.Serializable;

import org.junit.Assert;
import static org.junit.Assert.*;

/**
 * Created by grzesiek on 15.04.17.
 */
public class PointEntityTest {
    private SessionFactory ourSessionFactory;
    private Session session = null;
    private PointEntity point;
    private PointEntity anotherPoint;
    private UserEntity user;
    /* create simple user and two identical points
    *  before each test */
    @Before
    public void before(){
        point = new PointEntity();
        anotherPoint = new PointEntity();

        user = new UserEntity();
        user.setId(99999);
        user.setLogin("johnsmith99");
        user.setPasshash("smith99");

        point.setId(point.hashCode());
        point.setLatitude(51);
        point.setLongitude(23);
        point.setName("simplename");
        point.setUserByOwner(user);

        anotherPoint.setId(point.getId());
        anotherPoint.setLatitude(point.getLatitude());
        anotherPoint.setLongitude(point.getLongitude());
        anotherPoint.setName(point.getName());
        anotherPoint.setUserByOwner(point.getUserByOwner());

    }

    @Test
    public void addNewPointTest() {
        PointEntity newPoint;

        openSession();
        session.save(user);
        Serializable save = session.save(point);
        newPoint = (PointEntity) session.get(PointEntity.class, point.getId());
        closeSession();

        Assert.assertNotNull(newPoint);
        Assert.assertEquals(newPoint.getId(), point.getId());
        Assert.assertEquals(newPoint.getLatitude(), point.getLatitude(), 0.1);
        Assert.assertEquals(newPoint.getLongitude(), point.getLongitude(), 0.1);
        Assert.assertEquals(newPoint.getName(), point.getName());
        assertEquals(newPoint.getUserByOwner(), point.getUserByOwner());
    }

    @Test
    public void equalsMethodWithNullArgumentTest() {
        Assert.assertFalse(point.equals(null));
    }

    @Test
    public void equalsMethodDifferentIDTest() {
        point.setId(point.getId()+1);

        Assert.assertFalse(point.equals(anotherPoint));
    }

    @Test
    public void equalsMethodDifferentLatitudeTest() {
        point.setLatitude(point.getLatitude()+1);

        Assert.assertFalse(point.equals(anotherPoint));
    }

    @Test
    public void equalsMethodDifferentLongitudeTest() {
        point.setLongitude(point.getLongitude()+1);

        Assert.assertFalse(point.equals(anotherPoint));
    }

    @Test
    public void equalsMethodDifferentNameTest() {
        point.setName(point.getName() + "A");

        Assert.assertFalse(point.equals(anotherPoint));
    }

    private void openSession() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
            session = ourSessionFactory.openSession();
        } catch (Throwable ex) {
            Assert.fail(ex.getMessage());
        }
    }

    private void closeSession() {
        session.close();
        ourSessionFactory.close();
    }
}
