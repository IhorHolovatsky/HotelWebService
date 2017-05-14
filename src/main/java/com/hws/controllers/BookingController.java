package com.hws.controllers;

import com.hws.DAO.interfaces.IRoomTypeDAO;
import com.hws.Services.nonsecurity.interfaces.IBookingService;
import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.Room;
import com.hws.hibernate.models.RoomType;
import com.hws.viewModels.SearchArgs;
import javafx.scene.input.DataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Ihor on 5/13/2017.
 */
@Controller
public class BookingController extends ControllerBase {

    @Autowired
    IBookingService bookingService;
    @Autowired
    IRoomTypeDAO roomTypeDAO;
    SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");

    @RequestMapping(value = "/Rooms", method = RequestMethod.GET)
    public ModelAndView Index(String startDateString) throws ParseException {
        ModelAndView model = new ModelAndView("Bookings/Index");

        Date startDate;
        Date endDate = new Date();
        if (startDateString == null){
            startDate = new Date();
        } else{
            startDate = dataFormat.parse(startDateString);
            endDate = startDate;
        }

        ResponseWrapper<List<Room>> result =  bookingService.getAvailableRooms(startDate, endDate);
        List<RoomType> roomTypes =  roomTypeDAO.GetAllRoomTypes();

        if (!result.IsSuccess)
            return new ModelAndView("redirect:/Error?errorMessage=" + result.getErrorMessage());

        model.addObject("rooms", result.ResponseData);
        model.addObject("roomTypes", roomTypes);
        model.addObject("startDate", dataFormat.format(startDate));
        model.addObject("endDate", dataFormat.format(endDate));
        return model;
    }

    @RequestMapping(value = "/SearchRooms", method = RequestMethod.POST)
    public @ResponseBody ModelAndView getAvailableRooms(@RequestBody SearchArgs searchArgs, BindingResult bindingResult, Model inputModel, HttpServletRequest servletRequest){

        ModelAndView model = new ModelAndView("Bookings/Rooms");

        ResponseWrapper<List<Room>> result =  bookingService.getAvailableRooms(searchArgs.getStartDate(),
                                                                               searchArgs.getEndDate(),
                                                                               searchArgs.getRoomTypeUUID());

        if (!result.IsSuccess)
            return null;

        model.addObject("rooms", result.ResponseData);
        return model;
    }
}
