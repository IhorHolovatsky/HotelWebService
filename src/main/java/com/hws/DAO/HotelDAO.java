package com.hws.DAO;

import com.hws.hibernate.models.Hotel;
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
public class HotelDAO {
    @Autowired
    private SessionFactory sessionFactory;

    //NOTE this is a new method and has been added to make testing easier!
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Hotel> GetAllHotels(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select h from Hotel h");
        return query.list();
    }

    @Transactional
    public Hotel GetHotelById(UUID HotelId){
        Session session = sessionFactory.getCurrentSession();
        return (Hotel)session.get(Hotel.class, HotelId);
    }

    @Transactional
    public Hotel AddNewHotel(Hotel Hotel){
        Hotel.setHotelId(UUID.randomUUID());

        Session session = sessionFactory.getCurrentSession();
        return (Hotel) session.save(Hotel);
    }

    @Transactional
    public void UpdateHotel(Hotel Hotel){
        Session session = sessionFactory.getCurrentSession();
        session.update(Hotel);
    }

    @Transactional
    public void DeleteHotelById(UUID HotelId){
        Hotel HotelToDelete = this.GetHotelById(HotelId);
        this.DeleteHotel(HotelToDelete);
    }

    @Transactional
    public void DeleteHotel(Hotel HotelToDelete){
        Session session = sessionFactory.getCurrentSession();
        session.delete(HotelToDelete);
    }

}
