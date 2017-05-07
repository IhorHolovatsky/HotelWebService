package com.hws.controllers;

import com.hws.hibernate.models.TestConnection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.util.*;

/**
 * Created by Ihor on 3/28/2017.
 */
@Controller
public class HomeController extends ControllerBase{

    @RequestMapping(value="/Index", method = RequestMethod.GET)
    public ModelAndView Index(){
        ModelAndView model = new ModelAndView("Home/Index");

        TestConnection testConnection = new TestConnection();
        testConnection.setName("I'm test spring MVC model!");

        model.addObject("TestObject", testConnection);
        return model;
    }

}
