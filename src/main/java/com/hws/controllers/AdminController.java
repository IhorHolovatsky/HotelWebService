package com.hws.controllers;

import com.hws.Services.nonsecurity.interfaces.IRoomDetailService;
import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by nazar on 5/13/2017.
 */

@Controller
public class AdminController extends ControllerBase {

    @Autowired
    private HttpServletRequest context;

    @Autowired
    IRoomDetailService _roomDetailService;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value="/Secured/Admin/Index", method = RequestMethod.GET)
    public ModelAndView Index(){
        ModelAndView model = new ModelAndView("Admin/Index");
        ResponseWrapper<List<Room>> responseWrapper = _roomDetailService.GetAllRooms();

        if(responseWrapper.getIsSuccess()){
            List<Room> allRooms = responseWrapper.ResponseData;
            model.addObject("allRooms", allRooms);
        } else{ }

        return model;
    }

}