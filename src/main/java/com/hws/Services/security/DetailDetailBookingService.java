package com.hws.Services.security;

import com.hws.DAO.interfaces.IBookingDAO;
import com.hws.DAO.interfaces.IBookingRoomDAO;
import com.hws.DAO.interfaces.ICustomerDAO;
import com.hws.Services.security.interfaces.IDetailBookingService;
import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.Booking;
import com.hws.hibernate.models.BookingRoom;
import com.hws.hibernate.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by olecs on 5/14/2017.
 */
@Service
public class DetailDetailBookingService implements IDetailBookingService {

    @Autowired
    ICustomerDAO _customerDao;

    @Autowired
    IBookingDAO _bookingDao;

    @Autowired
    IBookingRoomDAO _bookingRoomDao;

    @Override
    public ResponseWrapper<BookingRoom> AddBooking(Date startDate, Date endDate, UUID roomId, UUID userId) {

        ResponseWrapper<BookingRoom> result = new ResponseWrapper<BookingRoom>();
        try {
            Customer currentCustomer = _customerDao.GetCustomerByUserId(userId);

            Booking booking = new Booking(new Date(), "comment", currentCustomer.getCustomerId());
            booking = _bookingDao.AddNewBooking(booking);

            BookingRoom bookingRoom = new BookingRoom();

            bookingRoom.setRoomId(roomId);
            bookingRoom.setBookingId(booking.getBookingId());
            bookingRoom.setStartDate(startDate);
            bookingRoom.setEndDate(endDate);

            bookingRoom = _bookingRoomDao.AddNewBookingRoom(bookingRoom);

            result.ResponseData = bookingRoom;

        }
        catch (Exception ex){
            result.setIsSuccess(false);
        }
        finally {
            return result;
        }

    }
}
