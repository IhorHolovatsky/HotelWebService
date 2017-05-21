package com.hws.hibernate.models;


import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.awt.print.Book;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Ihor on 4/9/2017.
 */
@Data
@Entity
@Component
@Table(name = "BookingRoom",
       uniqueConstraints = {@UniqueConstraint(columnNames = "BookingRoomID")})
public class BookingRoom {
    @Id
    @Column(name = "BookingRoomID")
    @Type(type = "uuid-char")
    private UUID BookingRoomId;

    @Column(name= "BookingID")
    @Type(type = "uuid-char")
    private UUID BookingId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BookingID", updatable = false, insertable = false)
    private Booking Booking;

    @Column(name = "RoomID")
    @Type(type = "uuid-char")
    private UUID RoomId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RoomID", updatable = false, insertable = false)
    private Room Room;

    @Column(name = "GuestID")
    @Type(type = "uuid-char")
    private UUID GuestId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GuestID", updatable = false, insertable = false)
    private Guest Guest;

    @Column(name = "StartDate")
    private Date StartDate;

    @Column(name = "EndDate")
    private Date EndDate;

    public BookingRoom(){ }

    public BookingRoom(Date startDate, Date endDate){
        this(startDate,endDate, null);
    }

    public BookingRoom(Date startDate, Date endDate, UUID guestId){
        StartDate = startDate;
        EndDate = endDate;
        GuestId = guestId;
    }

    public String getStartDateFormat(){
        Date startDate = getStartDate();

        if (startDate == null)
            return "";

        return new SimpleDateFormat("dd/MM/yyyy").format(startDate);
    }

    public String getEndDateFormat(){
        Date endDate = getEndDate();

        if (endDate == null)
            return "";

        return new SimpleDateFormat("dd/MM/yyyy").format(endDate);
    }
}
