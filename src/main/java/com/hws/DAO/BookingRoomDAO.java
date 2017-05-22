package com.hws.DAO;

import com.hws.DAO.interfaces.IBookingRoomDAO;
import com.hws.hibernate.models.BookingRoom;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by nazar on 4/16/2017.
 */

@Service
public class BookingRoomDAO implements IBookingRoomDAO {

    @Autowired
    private SessionFactory sessionFactory;

    //NOTE this is a new method and has been added to make testing easier!
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<BookingRoom> GetAllBookingRooms(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select br from BookingRoom br");
        return query.list();
    }

    @Transactional
    public BookingRoom GetBookingRoomById(UUID bookingRoomId){
        Session session = sessionFactory.getCurrentSession();
        return (BookingRoom)session.get(BookingRoom.class, bookingRoomId);
    }

    @Transactional
    public BookingRoom AddNewBookingRoom(BookingRoom bookingRoom){
        bookingRoom.setBookingRoomId(UUID.randomUUID());

        Session session = sessionFactory.getCurrentSession();
        session.save(bookingRoom);
        return bookingRoom;
    }

    @Transactional
    public void UpdateBookingRoom(BookingRoom bookingRoom){
        Session session = sessionFactory.getCurrentSession();
        session.update(bookingRoom);
    }

    @Transactional
    public void DeleteBookingRoomById(UUID bookingRoomId){
        BookingRoom bookingRoomToDelete = this.GetBookingRoomById(bookingRoomId);
        this.DeleteBookingRoom(bookingRoomToDelete);
    }

    @Transactional
    public void DeleteBookingRoom(BookingRoom bookingRoomToDelete){
        Session session = sessionFactory.getCurrentSession();
        session.delete(bookingRoomToDelete);
    }

    @Transactional
    public List<BookingRoom> GetBookings(Date startDate, Date endDate){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select br from BookingRoom br where (:startDate between br.StartDate and br.EndDate) or (:endDate between br.StartDate and br.EndDate)");
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);

        return query.list();
    }

}