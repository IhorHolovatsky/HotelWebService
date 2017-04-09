package hibernate;

import com.hws.hibernate.models.TestConnection;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Ihor on 4/8/2017.
 */
public class HibernateConnectionTest {

    @Test
    public void OpenSessionTest(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @Test
    public void InsertTest(){
        TestConnection model = new TestConnection();
        model.setId(1);
        model.setName("Unit Test");
        model.setInsertTime(new Date());

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
    }

    @Test
    public void DeleteAllTest(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("delete from com.hws.hibernate.models.TestConnection").executeUpdate();
        session.getTransaction().commit();
    }
}