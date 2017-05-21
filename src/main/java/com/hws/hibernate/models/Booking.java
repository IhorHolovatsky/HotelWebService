package com.hws.hibernate.models;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @OneToMany(mappedBy = "Booking", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

    public String getDateTimeMadeFormat(){
        Date dateTimeMade = getDateTimeMade();

        if (dateTimeMade == null)
            return "";

        return new SimpleDateFormat("dd/MM/yyyy hh:mm a").format(dateTimeMade);
    }

    public String getRoomCost(){
        BookingRoom booking = getBookingRooms().get(0);

        if (booking == null)
            return null;


        int diffInDays = (int) ((booking.getEndDate().getTime() - booking.getStartDate().getTime()) / (1000 * 60 * 60 * 24));

        String currentPrice = booking.getRoom().getPrice().toString();


        if(diffInDays != 0){
            currentPrice  = booking.getRoom().getPrice().multiply(new BigDecimal(diffInDays)).toString();
        }

        return currentPrice;
    }
}