package com.hws.Services.security.interfaces;

import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.User;

/**
 * Created by Ihor on 5/13/2017.
 */
public interface IUserProfileService {
    ResponseWrapper<User> UpdateUserProfile(User user);
}
