package com.hws.controllers;

import com.hws.Services.security.interfaces.IUserProfileService;
import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.Customer;
import com.hws.hibernate.models.User;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Ihor on 4/17/2017.
 */
@Controller
public class UserController extends ControllerBase {

    @Autowired
    IUserProfileService userProfileService;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/Secured/User/Index", method = RequestMethod.GET)
    public ModelAndView userHome() {
        ModelAndView model = new ModelAndView("User/Index");
        model.addObject("UserName", this.getCurrentUserName());
        return model;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/Secured/User/Profile", method = RequestMethod.GET)
    public ModelAndView userProfile(User user, String errorMessage) {
        ModelAndView model = new ModelAndView("User/Profile");

        User currentUser;
        if (user == null || user.getUserId() == null) {
            currentUser = getUser();
        } else {
            currentUser = user;
        }

        if (currentUser.getCustomer() == null) {
            currentUser.setCustomer(new Customer());
        }

        model.addObject("userProfile", currentUser);

        if (errorMessage != null){
            model.addObject("errorMessage", errorMessage);
        }
        return model;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/Secured/User/Profile", method = RequestMethod.POST)
    @ModelAttribute("com/hws/hibernate/models/User.java")
    public ModelAndView saveProfile(User userProfile) {
        ResponseWrapper<User> response = userProfileService.UpdateUserProfile(userProfile);

        if (response.IsSuccess) {
            return new ModelAndView("redirect:/Secured/User/Profile");
        }

        ModelAndView model = new ModelAndView("User/Profile");
        model.addObject("userProfile", response.ResponseData);
        model.addObject("errorMessage", String.join("</br>", response.ErrorMessages));
        return model;
    }
}
