package com.hws.hibernate.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="TestConnection",
        uniqueConstraints={@UniqueConstraint(columnNames={"Id"})})
public class TestConnection {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id", nullable=false, unique=true, length=11)
    private int id;

    @Column(name="Name", length=20, nullable=true)
    private String name;

    @Column(name="InsertTime", nullable=true)
    private Date insertTime;
}
