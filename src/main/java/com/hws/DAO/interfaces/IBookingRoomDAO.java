package com.hws.DAO.interfaces;

import com.hws.hibernate.models.BookingRoom;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

/**
 * Created by nazar on 5/12/2017.
 */
public interface IBookingRoomDAO {
    void setSessionFactory(SessionFactory sessionFactory);
    List<BookingRoom> GetAllBookingRooms();
    BookingRoom GetBookingRoomById(UUID bookingRoomId);
    BookingRoom AddNewBookingRoom(BookingRoom bookingRoom);
    void UpdateBookingRoom(BookingRoom bookingRoom);
    void DeleteBookingRoomById(UUID bookingRoomId);
    void DeleteBookingRoom(BookingRoom bookingRoomToDelete);
}
