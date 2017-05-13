package com.hws.viewModels;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Ihor on 5/13/2017.
 */
public class SearchArgs {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public String RoomTypeId;
    public String StartDate;
    public String EndDate;

    public UUID getRoomTypeUUID(){
        if (RoomTypeId == null)
            return null;

        return UUID.fromString(RoomTypeId);
    }

    public Date getStartDate(){
        if (StartDate == null)
            return null;

        try {
            return dateFormat.parse(StartDate);
        } catch (ParseException e) {
            return null;
        }
    }

    public Date getEndDate(){
        if (EndDate == null)
            return null;

        try {
            return dateFormat.parse(EndDate);
        } catch (ParseException e) {
            return null;
        }
    }
}
