package com.hws.Services.security.interfaces;

import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.Room;

import java.util.Date;
import java.util.List;

/**
 * Created by Ihor on 5/13/2017.
 */
public interface IBookingService {
    ResponseWrapper<List<Room>> getAvailableRooms(Date startDate);
    ResponseWrapper<List<Room>> getAvailableRooms(Date startDate, Date endDate);
}
