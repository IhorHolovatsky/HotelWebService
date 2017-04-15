package com.hws.hibernate.models;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Ihor on 4/15/2017.
 */
@Data
@Entity
@Table(name = "Address",
       uniqueConstraints = { @UniqueConstraint(columnNames = "AddressID")})
public class Address {

    @Id
    @Column(name = "AddressID")
    private UUID AddressId;

    @Column(name = "City")
    private String City;

    @Column(name = "Country")
    private String Country;

    @Column(name = "Phone")
    private String Phone;

    @Column(name = "Street")
    private String Street;

    @Column(name = "ZipCode")
    private String ZipCode;
}
