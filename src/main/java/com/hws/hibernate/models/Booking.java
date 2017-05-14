package com.hws.hibernate.models;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Nazar on 4/9/2017.
 */
@Data
@Entity
@Table(name="Booking",
        uniqueConstraints={@UniqueConstraint(columnNames={"BookingID"})})
public class Booking {
    @Id
    @Column(name="BookingID", nullable=false, unique=true)
    @Type(type = "uuid-char")
    private UUID BookingId;

    @Column(name="CustomerID")
    @Type(type = "uuid-char")
    private UUID CustomerId;

    @ManyToOne
    @JoinColumn(name = "CustomerID", updatable = false, insertable = false)
    private Customer Customer;

    @Column(name = "DateTimeMade")
    private Date DateTimeMade;

    @Column(name="BookingComment", length=100, nullable=true)
    private String BookingComment;

    @OneToMany(mappedBy = "Booking", cascade = CascadeType.ALL)
    private List<BookingRoom> BookingRooms;

    public Booking() {
        this(null,
                null,null);
    }

    public Booking(Date dateTimeMade, String bookingComment, UUID customerId) {
        DateTimeMade = dateTimeMade;
        BookingComment = bookingComment;
        CustomerId = customerId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "BookingId=" + BookingId +
                ", CustomerId=" + CustomerId +
                ", DateTimeMade=" + DateTimeMade +
                ", BookingComment='" + BookingComment + '\'' +
                '}';
    }
}