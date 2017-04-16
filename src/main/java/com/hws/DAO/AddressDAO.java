package com.hws.DAO;

import com.hws.hibernate.models.Address;
import com.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

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

    @Transactional
    public List<Address> GetAllAddresses(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select a from Address a");
        return query.list();
    }

    @Transactional
    public Address GetAddressById(UUID addressId){
        Session session = sessionFactory.getCurrentSession();
        return (Address)session.get(Address.class, addressId);
    }

    @Transactional
    public Address AddNewAddress(Address address){
        address.setAddressId(UUID.randomUUID());

        Session session = sessionFactory.getCurrentSession();
        return (Address)session.save(address);
    }

    @Transactional
    public void UpdateAddress(Address address){
        Session session = sessionFactory.getCurrentSession();
        session.update(address);
    }

    @Transactional
    public void DeleteAddressById(UUID addressId){
        Address addressToDelete = this.GetAddressById(addressId);
        this.DeleteAddress(addressToDelete);
    }

    @Transactional
    public void DeleteAddress(Address addressToDelete){
        Session session = sessionFactory.getCurrentSession();
        session.delete(addressToDelete);
    }
}
