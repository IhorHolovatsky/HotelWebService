package com.hws.DAO;

import com.hws.DAO.interfaces.IGuestDAO;
import com.hws.hibernate.models.Guest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ihor on 4/16/2017.
 */

@Service
public class GuestDAO implements IGuestDAO {

    @Autowired
    private SessionFactory sessionFactory;

    //NOTE this is a new method and has been added to make testing easier!
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Guest> GetAllGuests(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select f from Guest f");
        return query.list();
    }

    @Transactional
    public Guest GetGuestById(UUID guestId){
        Session session = sessionFactory.getCurrentSession();
        return (Guest)session.get(Guest.class, guestId);
    }

    @Transactional
    public Guest AddNewGuest(Guest guest){
        guest.setGuestId(UUID.randomUUID());

        Session session = sessionFactory.getCurrentSession();
        return (Guest) session.save(guest);
    }

    @Transactional
    public void UpdateGuest(Guest guest){
        Session session = sessionFactory.getCurrentSession();
        session.update(guest);
    }

    @Transactional
    public void DeleteGuestById(UUID guestId){
        Guest guestToDelete = this.GetGuestById(guestId);
        this.DeleteGuest(guestToDelete);
    }

    @Transactional
    public void DeleteGuest(Guest guestToDelete){
        Session session = sessionFactory.getCurrentSession();
        session.delete(guestToDelete);
    }
}
