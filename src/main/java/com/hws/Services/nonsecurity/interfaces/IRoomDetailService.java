package com.hws.Services.nonsecurity.interfaces;

import com.hws.SharedEntities.ResponseWrapper;
import com.hws.hibernate.models.Room;
import com.hws.hibernate.models.User;

import java.util.UUID;

/**
 * Created by olecs on 5/13/2017.
 */
public interface IRoomDetailService {
    ResponseWrapper<Room> GetCurrentRoom(UUID roomId);
}
