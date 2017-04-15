package com.hws.controllers;

import com.hws.hibernate.models.Booking;
import com.hws.hibernate.models.Customer;
import com.hws.hibernate.models.TestConnection;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.*;

/**
 * Created by Ihor on 3/28/2017.
 */
@Controller
public class HomeController {

    @RequestMapping(value="/Index")
    public ModelAndView Index(){
        ModelAndView model = new ModelAndView("Home/Index");

        TestConnection testConnection = new TestConnection();
        testConnection.setName("I'm test spring MVC model!");

        model.addObject("TestObject", testConnection);

        Session dbContext = HibernateUtil.getSessionFactory().openSession();

        List<Customer> customers = dbContext.createCriteria(Customer.class).list();

        Booking booking = customers.get(0).getBookings().get(0);
        String firstName = booking.getCustomer().getFirstName();
        return model;
    }

}
