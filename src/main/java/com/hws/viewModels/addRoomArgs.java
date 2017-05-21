package com.hws.viewModels;

import com.util.StringUtil;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.UUID;

/**
 * Created by nazar on 5/14/2017.
 */
public class addRoomArgs {

    public String RoomTypeId;
    public String Name;
    public BigDecimal Price;
    public Integer Number;
    public Integer Floor;
    public String Comment;
    public String ImageData;

    public String getImageData(){
        return ImageData;
    }
    public void setImageData(String imageData){
        ImageData = imageData;
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

    public BigDecimal getPrice(){
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

    public byte[] getImageBytes(){
        if (StringUtil.IsNullOrEmpty(ImageData)){
            return null;
        }

        return Base64.getDecoder().decode(ImageData);
    }

}

