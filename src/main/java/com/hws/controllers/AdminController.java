package com.hws.controllers;

import com.hws.DAO.interfaces.IRoomDAO;
import com.hws.Services.nonsecurity.interfaces.IRoomDetailService;
import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.Room;
import com.hws.viewModels.addRoomArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

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

        if(!responseWrapper.IsSuccess)
            return new ModelAndView("redirect:/Error?errorMessage=" + responseWrapper.getErrorMessage());

        List<Room> allRooms = responseWrapper.ResponseData;
        model.addObject("allRooms", allRooms);

        return model;
    }

    @RequestMapping(value = "/Secured/Admin/AddRoom", method = RequestMethod.POST)
    public @ResponseBody ModelAndView addRoom(@RequestBody addRoomArgs addArgs,
                                                        HttpServletRequest servletRequest){

        ModelAndView model = new ModelAndView("Admin/RoomsDB");
        Room room = new Room(UUID.randomUUID(), UUID.fromString("91537EB6-46CA-4926-988D-E1C12257D4CA"),
                addArgs.getRoomTypeUUID(), addArgs.Name
                ,addArgs.Price, addArgs.Number, addArgs.Floor, addArgs.Comment);
room.setImage(addArgs.getImageBytes());
        ResponseWrapper<Room> result = _roomDetailService.AddNewRoom(room);

        if (!result.IsSuccess)
            return null;

        ResponseWrapper<List<Room>> responseWrapper = _roomDetailService.GetAllRooms();
        model.addObject("allRooms", responseWrapper.ResponseData);
        return model;
    }

    @RequestMapping(value = "/Secured/Admin/DeleteRoom", method = RequestMethod.POST)
    public @ResponseBody ModelAndView deleteRoom(@RequestBody String roomId){
        ModelAndView model = new ModelAndView("Admin/RoomsDB");

        UUID roomUUUID = UUID.fromString(roomId);

        ResponseWrapper<Room> result = _roomDetailService.DeleteRoom(roomUUUID);

        if (!result.IsSuccess)
            return null;

        ResponseWrapper<List<Room>> responseWrapper = _roomDetailService.GetAllRooms();
        model.addObject("allRooms", responseWrapper.ResponseData);
        return model;
    }
}

