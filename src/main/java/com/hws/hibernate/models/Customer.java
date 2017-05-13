package com.hws.hibernate.models;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ihor on 4/9/2017.
 */
@Data
@Entity
@Table(name="Customer",
        uniqueConstraints={@UniqueConstraint(columnNames={"CustomerId"})})
public class Customer {
    @Id
    @Column(name="CustomerID", nullable=false, unique=true)
    @Type(type = "uuid-char")
    private UUID CustomerId;

    @Column(name="FirstName", length=20, nullable=false)
    private String FirstName;

    @Column(name="LastName", length=20, nullable=false)
    private String LastName;

    @Column(name="MiddleName", length=20, nullable=false, updatable = false)
    private String MiddleName;

    @Column(name="DateBirth", length=20, nullable=false)
    private Date DateBirth;

    @Column(name="HomePhone", length=20, nullable=false)
    private String HomePhone;

    @Column(name="Email", length=30, nullable=true)
    private String Email;

    @OneToMany(mappedBy = "Customer", cascade = CascadeType.ALL)
    private List<Booking> Bookings;

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerId=" + CustomerId +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", MiddleName='" + MiddleName + '\'' +
                ", DateBirth=" + DateBirth +
                ", HomePhone='" + HomePhone + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }

    public Customer(){ }

    public Customer(String firstName, String lastName, String middleName, Date dateBirth){
        FirstName = firstName;
        LastName = lastName;
        MiddleName = middleName;
        DateBirth = dateBirth;
    }

    public String getFormattedDateBirth(){
        Date birthDate = getDateBirth();
        
        if (birthDate == null)
            return "";

        return new SimpleDateFormat("dd/MM/yyyy").format(birthDate);
    }
}
