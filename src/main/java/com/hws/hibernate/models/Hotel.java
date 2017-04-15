package com.hws.hibernate.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ihor on 4/15/2017.
 */
@Entity
@Data
@Table(name = "Hotel")
public class Hotel {

    @Id
    @Column(name = "HotelID")
    private UUID HotelId;

    @Column(name = "AddressID")
    private UUID AddressId;

    @OneToOne
    private Address Address;

    @Column(name = "Description")
    private String Description;

    @Column(name = "HotelName")
    private String HotelName;

    @OneToMany(mappedBy = "Hotel")
    private List<Room> Rooms;
}
