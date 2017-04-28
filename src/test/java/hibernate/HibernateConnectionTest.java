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
}