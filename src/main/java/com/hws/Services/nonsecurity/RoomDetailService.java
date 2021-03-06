package com.hws.Services.nonsecurity;

import com.hws.DAO.interfaces.IRoomDAO;
import com.hws.Services.nonsecurity.interfaces.IRoomDetailService;
import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.Room;
import com.hws.viewModels.SearchArgs;
import com.hws.viewModels.addRoomArgs;
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

            result.IsSuccess = true;
            result.ResponseData = roomList;
            result.setIsSuccess(true);

        }
        catch (Exception ex){
            result.IsSuccess = false;
            result.AddErrorMessage(ex.getMessage());
        }
        finally {
            return result;
        }
    }

    @Override
    public ResponseWrapper<Room> AddNewRoom(Room room) {
        ResponseWrapper<Room> result = new ResponseWrapper<Room>();

        try {
            Room newRoom = _roomDao.AddNewRoom(room);

            result.ResponseData = newRoom;
            result.setIsSuccess(true);

        }
        catch (Exception ex){
            result.setIsSuccess(false);
            result.AddErrorMessage(ex.getMessage());
        }
        finally {
            return result;
        }
    }

    @Override
    public ResponseWrapper<Room> DeleteRoom(UUID roomId) {
        ResponseWrapper<Room> result = new ResponseWrapper<Room>();

        try {

            Room currentRoom = _roomDao.GetRoomById(roomId);

            _roomDao.DeleteRoom(currentRoom);

            result.setIsSuccess(true);

        }
        catch (Exception ex){
            result.setIsSuccess(false);
            result.AddErrorMessage(ex.getMessage());
        }
        finally {
            return result;
        }
    }

    @Override
    public ResponseWrapper<Room> EditRoom(Room room) {
        return null;
    }


}