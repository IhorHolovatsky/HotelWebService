package com.hws.controllers;

import com.hws.Services.nonsecurity.interfaces.IRoomDetailService;
import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.Room;

import com.hws.hibernate.models.RoomFacility;
import com.hws.hibernate.models.User;
import com.hws.viewModels.BookingViewModel;
import com.hws.viewModels.RegisterViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * Created by olecs on 5/13/2017.
 */
@Controller
public class RoomDetailPageController extends ControllerBase {

    @Autowired
    private HttpServletRequest context;

    @Autowired
    IRoomDetailService _roomDetailService;

    @RequestMapping(value="/RoomDetailPage", method = RequestMethod.GET)
    public ModelAndView Index() throws ParseException {

        ModelAndView model = new ModelAndView("RoomDetailPage/Index");

        String roomIdString = context.getParameter("roomId");
        String startDateString = context.getParameter("startDate");
        String endDateString = context.getParameter("endDate");

        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

        Date startDate = f.parse(startDateString);
        Date endDate = f.parse(endDateString);

        String bookingDateString = "You booking room from " + startDateString + " to " + endDateString;

        UUID roomId = UUID.fromString(roomIdString);

        ResponseWrapper<Room> responseWrapper = _roomDetailService.GetCurrentRoom(roomId);
        if(responseWrapper.getIsSuccess()){
            Room currentRoom = responseWrapper.ResponseData;

            if(currentRoom != null){
                model.addObject("IsSuccess",true);

                model.addObject("FacilitiesList",GetFacilitiesListFromRoomFacilities(currentRoom));

//                BookingViewModel bookingViewModel = new BookingViewModel();
//                bookingViewModel.Room = currentRoom;
//                bookingViewModel.StartDate = startDate;
//                bookingViewModel.EndDate = endDate;
//
//                model.addObject("BookingViewModel",bookingViewModel);
                model.addObject("Room",currentRoom);
                model.addObject("BookingTime",bookingDateString);
            }else{
                model.addObject("IsSuccess",false);
            }


         }else{
            model.addObject("IsSuccess",false);
        }

        return model;
    }

    @RequestMapping(value = "/RoomDetailPage/Booking", method = RequestMethod.POST)
    @ModelAttribute(value = "com/hws/viewModels/BookingViewModel.java")
    public ModelAndView Booking(BookingViewModel model){
        ModelAndView toReturn = new ModelAndView("redirect:/login");



        String a ="a";


        //ResponseWrapper<User> result = registerService.RegisterNewUser(model.getUsername(), model.getPassword());

//        if (!result.IsSuccess){
//            return new ModelAndView("redirect:/Register?error=" + result.getErrorMessage());
//        }
//        ModelAndView toReturn = new ModelAndView("redirect:/login");
//        toReturn.addObject("login", result.ResponseData.getLogin());
//        return toReturn;
        return toReturn;
    }
    
    private List<String> GetFacilitiesListFromRoomFacilities(Room room){
        List<String> result = new ArrayList<String>();
        for (RoomFacility roomFacility: room.getRoomFacility()
        ){
            result.add(roomFacility.getFacility().getName());
        }
        return result;
    }
}
