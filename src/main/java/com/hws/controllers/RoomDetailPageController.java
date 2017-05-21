package com.hws.controllers;

import com.hws.Services.nonsecurity.interfaces.IRoomDetailService;
import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.*;
import com.hws.Services.security.interfaces.IDetailBookingService;
import com.hws.viewModels.BookingViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
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

    @Autowired
    IDetailBookingService _bookingService;

   // @RequestMapping(value="/RoomDetailPage", method = RequestMethod.GET)
    @RequestMapping(value="/Secured/RoomDetailPage", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public ModelAndView Index(String roomId,String startDateString, String endDateString){
        if (roomId == null){
            return new ModelAndView("redirect:/Rooms");
        }
        ModelAndView model = new ModelAndView("RoomDetailPage/Index");
        UUID roomUUID = UUID.fromString(roomId);

        ResponseWrapper<Room> responseWrapper = _roomDetailService.GetCurrentRoom(roomUUID);
        if(responseWrapper.getIsSuccess()){
            Room currentRoom = responseWrapper.ResponseData;

            if(currentRoom != null){
                model.addObject("IsSuccess",true);

                model.addObject("FacilitiesList",GetFacilitiesListFromRoomFacilities(currentRoom));

                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

                Date startDate = new Date();
                Date endDate = new Date();
                try{
                 startDate = f.parse(startDateString);
                 endDate = f.parse(endDateString);
                }
                catch (ParseException ex){
                    model.addObject("IsSuccess",false);
                }

                int diffInDays = (int) ((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24));

                String currentPrice = currentRoom.getPrice().toString();


                if(diffInDays != 0){
                    currentPrice  = currentRoom.getPrice().multiply(new BigDecimal(diffInDays)).toString();
                }


                model.addObject("CurrentPrice",currentPrice);

                String bookingDateString = "You booking room from " + startDateString + " to " + endDateString;

                model.addObject("StartDate",startDateString);

                model.addObject("EndDate",endDateString);

                model.addObject("RoomId",currentRoom.getRoomId().toString());

                model.addObject("BookingTime",bookingDateString);

                model.addObject("Room",currentRoom);

                model.addObject("UserId",UUID.fromString(this.getUser().getUserId().toString()));
            }else{
                model.addObject("IsSuccess",false);
            }

         }else{
            model.addObject("IsSuccess",false);
        }

        return model;
    }

    @RequestMapping(value = "/Secured/RoomDetailPage/Booking", method = RequestMethod.POST)
  //  @RequestMapping(value = "/RoomDetailPage/Booking", method = RequestMethod.POST)
    @ModelAttribute(value = "com/hws/viewModels/BookingViewModel.java")
    public ModelAndView booking(BookingViewModel model){
        ModelAndView toReturn = new ModelAndView("redirect:/ThanksPage");

        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

        Date startDate = new Date();
        Date endDate = new Date();
        try{
            startDate = f.parse(model.StartDate);
            endDate = f.parse(model.EndDate);
        }
        catch (ParseException ex){

        }

        UUID RoomId = UUID.fromString(model.RoomId);
        UUID UserId = UUID.fromString(model.UserId);


        //END TEST

        _bookingService.AddBooking(startDate,endDate,RoomId,UserId);


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
