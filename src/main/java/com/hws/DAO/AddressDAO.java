package com.hws.DAO;

import com.hws.hibernate.models.Address;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Ihor on 4/15/2017.
 */
public class AddressDAO {

    @Autowired
    private SessionFactory sessionFactory;

    //NOTE this is a new method and has been added to make testing easier!
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Address> GetAllAddresses(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from Address a");
        return query.list();
    }

}
