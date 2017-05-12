package com.hws.DAO.interfaces;

import com.hws.hibernate.models.RoomType;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

/**
 * Created by nazar on 5/12/2017.
 */

public interface IRoomTypeDAO {
    void setSessionFactory(SessionFactory sessionFactory);
    List<RoomType> GetAllRoomTypes();
    RoomType GetRoomTypeById(UUID roomTypeId);
    RoomType AddNewRoomType(RoomType roomType);
    void UpdateRoomType(RoomType roomType);
    void DeleteRoomTypeById(UUID roomTypeId);
    void DeleteRoomType(RoomType roomTypeToDelete);
}