package com.hws.hibernate.models;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Ihor on 4/9/2017.
 */
@Data
@Entity
@Table(name = "Facility",
       uniqueConstraints = {@UniqueConstraint(columnNames = "FacilityID")})
public class Facility {

    @Id
    @Column(name = "FacilityID")
    @Type(type = "uuid-char")
    private UUID FacilityId;

    @Column(name = "FacilityName")
    private String Name;

    public Facility(){ }

    public Facility(String name){
        Name = name;
    }
}
