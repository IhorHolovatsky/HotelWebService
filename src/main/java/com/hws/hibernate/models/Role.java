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
@Table(name = "security_role")
public class Role {

    @Id
    @Column(name = "roleID")
    private UUID RoleId;

    @Column(name = "RoleName")
    private String RoleName;

    public Role() {
    }

    public Role(String roleName) {
        RoleName = roleName;
    }
}
