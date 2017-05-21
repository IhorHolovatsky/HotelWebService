package com.hws.Services.nonsecurity.interfaces;

import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.Booking;
import com.hws.hibernate.models.Room;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ihor on 5/13/2017.
 */
public interface IBookingService {
    ResponseWrapper<List<Room>> getAvailableRooms(Date startDate);
    ResponseWrapper<List<Room>> getAvailableRooms(Date startDate, Date endDate);
    ResponseWrapper<List<Room>> getAvailableRooms(Date startDate, Date endDate, UUID roomType);
    ResponseWrapper<List<Booking>> GetCustomerBookings(UUID customerId);
}
