package com.hws.Services.security;

import com.hws.DAO.interfaces.IBookingRoomDAO;
import com.hws.DAO.interfaces.IRoomDAO;
import com.hws.Services.security.interfaces.IBookingService;
import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.BookingRoom;
import com.hws.hibernate.models.Room;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ihor on 5/13/2017.
 */
public class BookingService implements IBookingService {
    @Autowired
    IBookingRoomDAO bookingRoomDAO;

    @Autowired
    IRoomDAO roomDAO;

    @Override
    public ResponseWrapper<List<Room>> getAvailableRooms(Date startDate) {
        return getAvailableRooms(startDate, startDate);
    }

    @Override
    public ResponseWrapper<List<Room>> getAvailableRooms(Date startDate, Date endDate) {
        ResponseWrapper<List<Room>> result = new ResponseWrapper<>();

        try{
            List<Room> allRooms = roomDAO.GetAvailableRooms(startDate, endDate);
            result.IsSuccess = true;
            result.ResponseData = allRooms;
        }catch (Exception e){
            result.IsSuccess = false;
            result.AddErrorMessage(e.getMessage());
        }

        return result;
    }
}
