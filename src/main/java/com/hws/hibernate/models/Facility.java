package com.hws.hibernate.models;

import lombok.Data;

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
    private UUID FacilityId;

    @Column(name = "FacilityName")
    private String Name;
}
