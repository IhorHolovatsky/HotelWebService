package com.hws.hibernate.models;


import lombok.Data;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Ihor on 4/9/2017.
 */
@Data
@Entity
@Table(name = "BookingRoom",
       uniqueConstraints = {@UniqueConstraint(columnNames = "BookingRoomID")})
public class BookingRoom {
    @Id
    @Column(name = "BookingRoomID")
    private UUID BookingRoomId;

    @Column(name= "BookingID")
    private UUID BookingId;

    @ManyToOne
    @JoinColumn(name = "BookingID", updatable = false, insertable = false)
    private Booking Booking;

    @Column(name = "RoomID")
    private UUID RoomId;

    @ManyToOne
    @JoinColumn(name = "RoomID", updatable = false, insertable = false)
    private Room Room;

    @Column(name = "GuestID")
    private UUID GuestId;

    @ManyToOne(cascade = CascadeType.ALL)
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
}
