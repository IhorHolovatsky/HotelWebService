package com.hws.DAO.interfaces;

import com.hws.hibernate.models.Room;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by nazar on 5/12/2017.
 */

public interface IRoomDAO {
    void setSessionFactory(SessionFactory sessionFactory);
    List<Room> GetAllRooms();
    Room GetRoomById(UUID roomId);
    Room AddNewRoom(Room room);
    void UpdateRoom(Room room);
    void DeleteRoomById(UUID roomId);
    void DeleteRoom(Room roomToDelete);
    List<Room> GetAvailableRooms(Date startDate, Date endDate);
}