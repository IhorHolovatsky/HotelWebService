package com.hws.controllers;

import com.hws.Services.nonsecurity.interfaces.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ihor on 3/28/2017.
 */
@Controller
public class HomeController extends ControllerBase {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Index() { return "Home/Index"; }

    @RequestMapping(value = "/Contact", method = RequestMethod.GET)
    public String ContactUs() {
        return "Home/Contact";
    }
}
