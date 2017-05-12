package com.hws.DAO.interfaces;

import com.hws.hibernate.models.Booking;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

/**
 * Created by nazar on 5/12/2017.
 */

public interface IBookingDAO {
    void setSessionFactory(SessionFactory sessionFactory);
    List<Booking> GetAllBookings();
    Booking GetBookingById(UUID bookingId);
    Booking AddNewBooking(Booking booking);
    void UpdateBooking(Booking booking);
    void DeleteBookingById(UUID bookingId);
    void DeleteBooking(Booking bookingToDelete);
}