package com.hws.hibernate.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Ihor on 4/9/2017.
 */
@Data
@Entity
@Table(name="Booking",
        uniqueConstraints={@UniqueConstraint(columnNames={"BookingID"})})
public class Booking {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="BookingID", nullable=false, unique=true)
    private UUID BookingId;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer CustomerId;

    @Column(name = "DateTimeMade")
    private Date DateTimeMade;

    @Column(name="BookingComment", length=100, nullable=true)
    private String BookingComment;
}
