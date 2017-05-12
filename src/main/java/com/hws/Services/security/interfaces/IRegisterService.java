package com.hws.Services.security.interfaces;

import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.User;
import com.hws.viewModels.RegisterViewModel;

/**
 * Created by Ihor on 5/7/2017.
 */
public interface IRegisterService {
    ResponseWrapper<User> RegisterNewUser(User user);
    ResponseWrapper<User> RegisterNewUser(String login, String password);
}
