package com.hws.hibernate.models;

import lombok.Data;
import org.hibernate.annotations.SQLUpdate;
import org.hibernate.annotations.Type;

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
    @Type(type = "uuid-char")
    private UUID UserId;

    @Column(name = "Login")
    private String Login;


    @Column(name = "Password", updatable = false)
    private String Password;

    @Column(name = "CustomerID")
    @Type(type = "uuid-char")
    private UUID CustomerId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CustomerID", insertable = false, updatable = false)
    private Customer Customer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "security_userInRole", joinColumns = {
                @JoinColumn(name = "UserID", nullable = false, updatable = false) },
                            inverseJoinColumns = { @JoinColumn(name = "RoleID",
                            nullable = false, updatable = false) })
    private List<Role> Roles;

    public User() {
    }

    public User(String login, String password) {
        Login = login;
        Password = password;
    }
}
