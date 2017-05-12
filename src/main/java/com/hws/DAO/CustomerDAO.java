package com.hws.DAO;

import com.hws.DAO.interfaces.ICustomerDAO;
import com.hws.hibernate.models.Customer;
import com.hws.hibernate.models.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ihor on 4/16/2017.
 */
@Service
public class CustomerDAO implements ICustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    //NOTE this is a new method and has been added to make testing easier!
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Customer> GetAllCustomers(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select c from Customer c");
        return query.list();
    }

    @Transactional
    public Customer GetCustomerById(UUID customerId){
        Session session = sessionFactory.getCurrentSession();
        return (Customer)session.get(Customer.class, customerId);
    }

    @Transactional
    public Customer AddNewCustomer(Customer customer){
        customer.setCustomerId(UUID.randomUUID());

        Session session = sessionFactory.getCurrentSession();
        return (Customer) session.save(customer);
    }

    @Transactional
    public void UpdateCustomer(Customer customer){
        Session session = sessionFactory.getCurrentSession();
        session.update(customer);
    }

    @Transactional
    public void DeleteCustomerById(UUID customerId){
        Customer customerToDelete = this.GetCustomerById(customerId);
        this.DeleteCustomer(customerToDelete);
    }

    @Transactional
    public void DeleteCustomer(Customer customerToDelete){
        Session session = sessionFactory.getCurrentSession();
        session.delete(customerToDelete);
    }
    
}
