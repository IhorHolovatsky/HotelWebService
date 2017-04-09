package com.hws.hibernate.models;


import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Ihor on 4/9/2017.
 */
@Entity
@Table(name="Customer",
        uniqueConstraints={@UniqueConstraint(columnNames={"CustomerId"})})
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CustomerID", nullable=false, unique=true)
    private UUID CustomerId;

    @Column(name="FirstName", length=20, nullable=false)
    private String FirstName;

    @Column(name="LastName", length=20, nullable=false)
    private String LastName;

    @Column(name="MiddleName", length=20, nullable=false)
    private String MiddleName;

    @Column(name="DateBirth", length=20, nullable=false)
    private Date DateBirth;

    @Column(name="AddressStreet", length=40, nullable=false)
    private String AddressStreet;

    @Column(name="AddressTown", length=30, nullable=false)
    private String AddressTown;

    @Column(name="AddressCountry", length=30, nullable=false)
    private String AddressCountry;

    @Column(name="AddressZipCode", length=11, nullable=false)
    private String AddressZipCode;

    @Column(name="WorkPhone", length=20, nullable=false)
    private String WorkPhone;

    @Column(name="HomePhone", length=20, nullable=false)
    private String HomePhone;

    @Column(name="Email", length=30, nullable=false)
    private String Email;

}
