package com.hws.hibernate.models;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by Ihor on 4/15/2017.
 */
@Data
@Entity
@Component
@Table(name ="Room")
public class Room {

    @Id
    @Column(name = "RoomID")
    @Type(type = "uuid-char")
    private UUID RoomId;

    @Column(name = "Floor")
    private int Floor;

    @Column(name = "Number")
    private int Number;

    @Column(name = "HotelID")
    @Type(type = "uuid-char")
    private UUID HotelId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HotelID", updatable = false, insertable = false)
    private Hotel Hotel;

    @Column(name = "Price")
    private BigDecimal Price;

    @Column(name = "AdditionalNotes")
    private String AdditionalNotes;

    @Column(name = "RoomTypeID")
    @Type(type = "uuid-char")
    private UUID RoomTypeID;

    @Column(name = "Image")
    private byte[] Image;

    @Column(name = "Name")
    private String Name;

    @OneToMany(mappedBy = "Room",fetch = FetchType.EAGER)
    private List<BookingRoom> RoomBookings;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RoomTypeID", updatable = false, insertable = false)
    private RoomType RoomType;

    @OneToMany(mappedBy = "Room", fetch = FetchType.EAGER)
    private List<RoomFacility> RoomFacility;

    public List<Facility> getFacilities(){
        if (RoomFacility.size() >= 0){
            return RoomFacility.stream()
                               .map(x -> x.getFacility())
                               .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    public Room () {}

    public Room(int floor, int number) {
        Floor = floor;
        Number = number;
    }
}
