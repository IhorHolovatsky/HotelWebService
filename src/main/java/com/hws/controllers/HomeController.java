package com.hws.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ihor on 3/28/2017.
 */
@Controller
public class HomeController {

    @RequestMapping(value="/Index")
    public String Index(){
        return "Index";
    }

}
