package com.hws.controllers;

import com.hws.Services.nonsecurity.interfaces.IRoomDetailService;
import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
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
    public String Index(){

        String roomIdString = context.getParameter("roomId");
        UUID roomId = UUID.fromString(roomIdString);

        ResponseWrapper<Room> responseWrapper = _roomDetailService.GetCurrentRoom(roomId);
        if(responseWrapper.getIsSuccess()){
            Room currentRoom = responseWrapper.ResponseData;
        }else{

        }

        return "RoomDetailPage/Index";
    }
}
