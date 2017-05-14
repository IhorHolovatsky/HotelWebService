package com.hws.Services.security.interfaces;

import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.Booking;
import com.hws.hibernate.models.BookingRoom;

import java.util.Date;
import java.util.UUID;

/**
 * Created by olecs on 5/14/2017.
 */
public interface IDetailBookingService {
    ResponseWrapper<BookingRoom> AddBooking(Date startDate, Date endDate, UUID customerId, UUID roomId);
}
