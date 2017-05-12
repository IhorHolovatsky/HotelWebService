package com.hws.DAO.interfaces;

import com.hws.hibernate.models.Hotel;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

/**
 * Created by nazar on 5/12/2017.
 */

public interface IHotelDAO {
    void setSessionFactory(SessionFactory sessionFactory);
    List<Hotel> GetAllHotels();
    Hotel GetHotelById(UUID HotelId);
    Hotel AddNewHotel(Hotel Hotel);
    void UpdateHotel(Hotel Hotel);
    void DeleteHotelById(UUID HotelId);
    void DeleteHotel(Hotel HotelToDelete);
}