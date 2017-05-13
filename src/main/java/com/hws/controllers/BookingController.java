package com.hws.controllers;

import com.hws.Services.nonsecurity.interfaces.IBookingService;
import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * Created by Ihor on 5/13/2017.
 */
@Controller
public class BookingController extends ControllerBase {

    @Autowired
    IBookingService bookingService;

    @RequestMapping(value = "/Rooms", method = RequestMethod.GET)
    public ModelAndView Index(){

        ResponseWrapper<List<Room>> result =  bookingService.getAvailableRooms(new Date(), new Date());

        if (!result.IsSuccess)
            return new ModelAndView("redirect:/Error?errorMessage=" + result.getErrorMessage());
        return null;
    }
}
