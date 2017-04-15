package com.hws.hibernate.models;

import lombok.Data;
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
    private UUID RoomFacilityId;

    @Column(name = "FacilityID")
    private UUID FacilityId;

    @ManyToOne
    @JoinColumn(name = "FacilityID", updatable = false, insertable = false)
    private Facility Facility;

    @Column(name = "FaciliteDetails")
    private String FacilityDetails;

    @Column(name = "RoomID")
    private UUID RoomId;

    @ManyToOne
    @JoinColumn(name = "RoomID", updatable = false, insertable = false)
    private Room Room;

}
