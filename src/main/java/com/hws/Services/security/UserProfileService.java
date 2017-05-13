package com.hws.Services.security;

import com.hws.DAO.interfaces.ICustomerDAO;
import com.hws.DAO.interfaces.IUserDAO;
import com.hws.Services.security.interfaces.IUserProfileService;
import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.Customer;
import com.hws.hibernate.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ihor on 5/13/2017.
 */
@Service
public class UserProfileService implements IUserProfileService {

    @Autowired
    private IUserDAO userDAO;
    @Autowired
    private ICustomerDAO customerDAO;

    @Override
    public ResponseWrapper<User> UpdateUserProfile(User user) {
        ResponseWrapper<User> result = new ResponseWrapper();

        try{
            if (user.getCustomer().getCustomerId() != null){
                customerDAO.UpdateCustomer(user.getCustomer());
            } else{
                Customer customer = customerDAO.AddNewCustomer(user.getCustomer());
                user.setCustomerId(customer.getCustomerId());
                user.setCustomer(customer);
            }
            userDAO.UpdateUser(user);
            result.IsSuccess = true;
        }catch (Exception e){
            result.IsSuccess = false;
            result.AddErrorMessage(e.getMessage());
        }

        result.ResponseData = user;
        return result;
    }
}
