package com.hws.DAO.interfaces;

import com.hws.hibernate.models.Customer;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

/**
 * Created by Ihor on 5/7/2017.
 */

public interface ICustomerDAO {
    void setSessionFactory(SessionFactory sessionFactory);
    List<Customer> GetAllCustomers();
    Customer GetCustomerById(UUID userId);
    Customer AddNewCustomer(Customer user);
    void UpdateCustomer(Customer user);
    void DeleteCustomerById(UUID userId);
    void DeleteCustomer(Customer userToDelete);
}
