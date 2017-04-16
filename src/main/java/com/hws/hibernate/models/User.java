package com.hws.hibernate.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ihor on 4/16/2017.
 */
@Data
@Entity
@Table(name = "security_user")
public class User {

    @Id
    @Column(name = "UserID")
    private UUID UserId;

    @Column(name = "Login")
    private String Login;


    @Column(name = "Password")
    private String Password;

    @Column(name = "CustomerID")
    private UUID CustomerId;

    @OneToOne
    private Customer Customer;

    @ManyToMany
    private List<Role> Roles;
}
