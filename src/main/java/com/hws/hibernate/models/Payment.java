package com.hws.hibernate.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Ihor on 4/9/2017.
 */
@Entity
@Data
@Table(name = "Payment")
public class Payment {

    @Id
    @Column(name = "PaymentID")
    private UUID PaymentId;

    @Column(name = "BookingID")
    private UUID BookingId;

    @OneToOne
    private Booking Booking;

    @Column(name = "CustomerID")
    private UUID CustomerId;

    @OneToOne
    private Customer Customer;

    @Column(name = "PaymentComment")
    private String PaymentComment;

    @Column(name = "PaymentMethodID")
    private UUID PaymentMethodId;

    @OneToOne
    private PaymentMethod PaymentMethod;

    @Column(name = "DateTimeMade")
    private Date DateTimeMade;

    @Column(name = "TotalAmount")
    private BigDecimal TotalAmount;

    public Payment() {
    }

    public Payment(UUID bookingId, UUID customerId, String paymentComment, Date dateTimeMade, BigDecimal totalAmount) {
        BookingId = bookingId;
        CustomerId = customerId;
        PaymentComment = paymentComment;
        DateTimeMade = dateTimeMade;
        TotalAmount = totalAmount;
    }
}
