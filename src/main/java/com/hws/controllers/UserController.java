package com.hws.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Ihor on 4/17/2017.
 */
@Controller
public class UserController extends ControllerBase {

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/Secured/User/Index", method = RequestMethod.GET)
    public ModelAndView userHome() {
        ModelAndView model = new ModelAndView("User/Index");
        model.addObject("UserName", this.getCurrentUserName());
        return model;
    }
}
