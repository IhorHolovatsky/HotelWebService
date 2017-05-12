package com.hws.controllers;

import com.hws.Services.security.interfaces.IRegisterService;
import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.User;
import com.hws.viewModels.RegisterViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ihor on 4/16/2017.
 */
@Controller
public class SecurityController extends ControllerBase{

    @Autowired
    IRegisterService registerService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", error + " Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "Security/login";
    }

    @RequestMapping(value="/Logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public String register(Model model, String error){
        if (error != null)
            model.addAttribute("error", error);

        return "Security/register";
    }

    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    @ModelAttribute(value = "com/hws/viewModels/RegisterViewModel.java")
    public String register(RegisterViewModel model){

        ResponseWrapper<User> result = registerService.RegisterNewUser(model.getUsername(), model.getPassword());

        if (!result.IsSuccess){
            return "redirect:/Register?error=" + result.getErrorMessage();
        }

        return "redirect:/login";
    }
}
