package com.hws.DAO;

import com.hws.hibernate.models.Booking;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * Created by nazar on 4/16/2017.
 */
public class BookingDAO {

    @Autowired
    private SessionFactory sessionFactory;


    //NOTE this is a new method and has been added to make testing easier!
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Booking> GetAllBookings(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select b from Booking b");
        return query.list();
    }

    //GetAllCustomersById

    @Transactional
    public Booking GetBookingById(UUID bookingId){
        Session session = sessionFactory.getCurrentSession();
        return (Booking)session.get(Booking.class, bookingId);
    }

    @Transactional
    public Booking AddNewBooking(Booking booking){
        booking.setBookingId(UUID.randomUUID());

        Session session = sessionFactory.getCurrentSession();
        return (Booking)session.save(booking);
    }

    @Transactional
    public void UpdateBooking(Booking booking){
        Session session = sessionFactory.getCurrentSession();
        session.update(booking);
    }

    @Transactional
    public void DeleteBookingById(UUID bookingId){
        Booking bookingToDelete = this.GetBookingById(bookingId);
        this.DeleteBooking(bookingToDelete);
    }

    @Transactional
    public void DeleteBooking(Booking bookingToDelete){
        Session session = sessionFactory.getCurrentSession();
        session.delete(bookingToDelete);
    }
}
