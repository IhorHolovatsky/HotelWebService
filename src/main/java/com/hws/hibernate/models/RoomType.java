package com.hws.hibernate.models;

import lombok.Data;
import org.hibernate.annotations.Type;

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
    @Type(type = "uuid-char")
    private UUID RoomTypeId;

    @Column(name = "RoomType")
    private String RoomType;

    @Column(name = "MaxCapacity")
    private int MaxCapacity;

    public RoomType(){ }

    public RoomType(String roomType, int maxCapacity) {
        RoomType = roomType;
        MaxCapacity = maxCapacity;
    }
}
