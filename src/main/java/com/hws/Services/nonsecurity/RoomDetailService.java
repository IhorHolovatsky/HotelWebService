package com.hws.Services.nonsecurity;

import com.hws.DAO.interfaces.IRoomDAO;
import com.hws.Services.nonsecurity.interfaces.IRoomDetailService;
import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by olecs on 5/13/2017.
 */
@Service
public class RoomDetailService implements IRoomDetailService {

    @Autowired
    IRoomDAO _roomDao;

    @Override
    public ResponseWrapper<Room> GetCurrentRoom(UUID roomId) {

        ResponseWrapper<Room> result = new ResponseWrapper<Room>();

        try {
            Room currentRoom = _roomDao.GetRoomById(roomId);

            result.ResponseData = currentRoom;
            result.setIsSuccess(true);

        }
        catch (Exception ex){
            result.setIsSuccess(false);
        }
        finally {
            return result;
        }

    }

    @Override
    public ResponseWrapper<List<Room>> GetAllRooms() {
        ResponseWrapper<List<Room>> result = new ResponseWrapper<>();

        try {
            List<Room> roomList = _roomDao.GetAllRooms();

            result.ResponseData = roomList;
            result.setIsSuccess(true);

        }
        catch (Exception ex){
            result.setIsSuccess(false);
        }
        finally {
            return result;
        }
    }

    @Override
    public ResponseWrapper<Room> AddNewRoom(Room room) {
        ResponseWrapper<Room> result = new ResponseWrapper<Room>();

        try {
            Room currentRoom = _roomDao.AddNewRoom(room);

            result.ResponseData = currentRoom;
            result.setIsSuccess(true);

        }
        catch (Exception ex){
            result.setIsSuccess(false);
        }
        finally {
            return result;
        }
    }

}