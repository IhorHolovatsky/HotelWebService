package com.hws.DAO.interfaces;

import com.hws.hibernate.models.Guest;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

/**
 * Created by nazar on 5/12/2017.
 */
public interface IGuestDAO {
    void setSessionFactory(SessionFactory sessionFactory);
    List<Guest> GetAllGuests();
    Guest GetGuestById(UUID guestId);
    Guest AddNewGuest(Guest guest);
    void UpdateGuest(Guest guest);
    void DeleteGuestById(UUID guestId);
    void DeleteGuest(Guest guestToDelete);
}
