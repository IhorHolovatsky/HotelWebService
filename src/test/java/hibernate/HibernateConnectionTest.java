package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by Ihor on 4/8/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {""})
public class HibernateConnectionTest {

    //@Autowired
    //SessionFactory sessionFactory;

    @Test
    public void OpenSessionTest(){
        //Session session = sessionFactory.getCurrentSession();
    }
}