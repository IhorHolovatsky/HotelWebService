package com.hws.controllers;

import com.hws.DAO.interfaces.IUserDAO;
import com.hws.hibernate.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

/**
 * Created by Ihor on 4/16/2017.
 */
@Controller
public abstract class ControllerBase {

    @Autowired
    IUserDAO userDAO;

    protected UserDetails getUserDetais(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails)principal);
        }

        return null;
    }

    protected User getUser(){
       return userDAO.GetUserByLogin(getCurrentUserName());
    }

    protected String getCurrentUserName(){
        return getUserDetais().getUsername();
    }

    protected boolean hasRole(String roleName){
        return getUserDetais().getAuthorities()
                              .stream()
                              .anyMatch(a -> a.getAuthority() == roleName);
    }
}
