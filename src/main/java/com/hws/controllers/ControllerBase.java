package com.hws.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

/**
 * Created by Ihor on 4/16/2017.
 */
@Controller
public abstract class ControllerBase {

    protected UserDetails getUserDetais(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails)principal);
        }

        return null;
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
