package com.hws.viewModels;

import java.util.UUID;

/**
 * Created by nazar on 5/14/2017.
 */
public class addRoomArgs {
    public String RoomId;
    public String HotelId;
    public String RoomTypeId;
    public String Name;
    public Integer Price;
    public Integer Number;
    public Integer Floor;
    public String Comment;

    public UUID getRoomUUID(){
        if (RoomId == null)
            return null;

        return UUID.fromString(RoomTypeId);
    }

    public UUID getHotelUUID(){
        if (HotelId == null)
            return null;

        return UUID.fromString(RoomTypeId);
    }

    public UUID getRoomTypeUUID(){
        if (RoomTypeId == null)
            return null;

        return UUID.fromString(RoomTypeId);
    }

    public String getName(){
        if (Name == null)
            return null;

        return Name;
    }

    public Integer getPrice(){
        if (Price == null)
            return null;

        return Price;
    }

    public Integer getNumber(){
        if (Number == null)
            return null;

        return Number;
    }

    public Integer getFloor(){
        if (Floor == null)
            return null;

        return Floor;
    }

    public String getComment(){
        if (Comment == null)
            return null;

        return Comment;
    }

}

