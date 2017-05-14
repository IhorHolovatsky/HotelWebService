package com.hws.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by olecs on 5/14/2017.
 */
@Controller
public class ThanksPageController extends ControllerBase{
    @RequestMapping(value = "/ThanksPage", method = RequestMethod.GET)
    public String Index(){
        return "/ThanksPage/Index";
    }
}
