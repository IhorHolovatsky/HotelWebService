package com.hws.hibernate.models;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by nazar on 4/15/2017.
 */
@Entity
@Data
@Table(name = "Hotel")
public class Hotel {

    @Id
    @Column(name = "HotelID")
    @Type(type = "uuid-char")
    private UUID HotelId;

    @Column(name = "AddressID")
    @Type(type = "uuid-char")
    private UUID AddressId;

    @OneToOne
    @JoinColumn(name = "AddressID", updatable = false, insertable = false)
    private Address Address;

    @Column(name = "Description")
    private String Description;

    @Column(name = "HotelName")
    private String HotelName;

    @OneToMany(mappedBy = "Hotel")
    private List<Room> Rooms;

    public Hotel(){ }

    public Hotel(String hotelName, String description){
        HotelName = hotelName;
        Description = description;
    }
}
