package com.hws.DAO.interfaces;

import com.hws.hibernate.models.RoomFacility;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

/**
 * Created by nazar on 5/12/2017.
 */

public interface IRoomFacilityDAO {
    void setSessionFactory(SessionFactory sessionFactory);
    List<RoomFacility> GetAllRoomFacilities();
    RoomFacility GetRoomFacilityById(UUID RoomFacilityId);
    RoomFacility AddNewRoomFacility(RoomFacility RoomFacility);
    void UpdateRoomFacility(RoomFacility RoomFacility);
    void DeleteRoomFacilityById(UUID RoomFacilityId);
    void DeleteRoomFacility(RoomFacility RoomFacilityToDelete);
}