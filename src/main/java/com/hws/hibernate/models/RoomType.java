package com.hws.hibernate.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by Ihor on 4/15/2017.
 */
@Data
@Entity
@Table(name = "RoomType")
public class RoomType {
    @Id
    @Column(name = "RoomTypeID")
    private UUID RoomTypeId;

    @Column(name = "RoomType")
    private String RoomType;

    @Column(name = "MaxCapacity")
    private int MaxCapacity;
}
