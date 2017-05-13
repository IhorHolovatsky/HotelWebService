package com.hws.hibernate.models;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ihor on 4/9/2017.
 */
@Data
@Entity
@Table(name = "Guest")
public class Guest {

    @Id
    @Column(name = "GuestID")
    @Type(type = "uuid-char")
    private UUID GuestId;

    @Column(name = "AddressID")
    @Type(type = "uuid-char")
    private UUID AddressId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AddressID", insertable = false, updatable = false)
    private Address Addresses;

    @Column(name = "DateBirth")
    private Date DateBirth;

    @Column(name = "FirstName")
    private String FirstName;

    @Column(name = "LastName")
    private String LastName;

    @Column(name = "MiddleName")
    private String MiddleName;

    @OneToMany(mappedBy = "Guest")
    private List<BookingRoom> BookingRooms;

    public Guest(){ }

    public Guest(String firstName, String lastName, String middleName, Date dateBirth){
        FirstName = firstName;
        LastName = lastName;
        MiddleName = middleName;
        DateBirth = dateBirth;
    }
}
