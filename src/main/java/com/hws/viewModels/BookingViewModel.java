package com.hws.viewModels;

import com.hws.hibernate.models.Room;
import lombok.Data;

import java.util.Date;

/**
 * Created by olecs on 5/13/2017.
 */
@Data
public class BookingViewModel {
    public Room Room;
    public String StartDate;
    public String EndDate;

    public String RoomId;
    public String UserId;
}
