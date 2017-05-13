package com.hws.hibernate.models;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.jmx.export.annotation.ManagedNotification;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Ihor on 4/15/2017.
 */
@Data
@Entity
@Table(name = "RoomFacility",
       uniqueConstraints = {@UniqueConstraint(columnNames = "RoomFacilityID")})
public class RoomFacility {

    @Id
    @Column(name = "RoomFacilityID")
    @Type(type = "uuid-char")
    private UUID RoomFacilityId;

    @Column(name = "FacilityID")
    @Type(type = "uuid-char")
    private UUID FacilityId;

    @ManyToOne
    @JoinColumn(name = "FacilityID", updatable = false, insertable = false)
    private Facility Facility;

    @Column(name = "FacilityDetails")
    private String FacilityDetails;

    @Column(name = "RoomID")
    @Type(type = "uuid-char")
    private UUID RoomId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RoomID", updatable = false, insertable = false)
    private Room Room;

    public RoomFacility () {}

    public RoomFacility(String facilityDetails) {
        FacilityDetails = facilityDetails;
    }
}
