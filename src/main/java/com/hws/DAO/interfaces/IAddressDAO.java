package com.hws.DAO.interfaces;

import com.hws.hibernate.models.Address;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

/**
 * Created by nazar on 5/12/2017.
 */

public interface IAddressDAO {
    void setSessionFactory(SessionFactory sessionFactory);
    List<Address> GetAllAddresses();
    Address GetAddressById(UUID addressId);
    Address AddNewAddress(Address address);
    void UpdateAddress(Address address);
    void DeleteAddressById(UUID addressId);
    void DeleteAddress(Address addressToDelete);
}
