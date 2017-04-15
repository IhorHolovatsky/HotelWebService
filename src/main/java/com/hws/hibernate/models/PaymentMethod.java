package com.hws.hibernate.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by Ihor on 4/9/2017.
 */
@Entity
@Data
@Table(name = "PaymentMethod")
public class PaymentMethod {

    @Id
    @Column(name = "PaymentMethodID")
    private UUID PaymentMethodId;

    @Column(name = "PaymentMethod")
    private String PaymentMethod;
}
