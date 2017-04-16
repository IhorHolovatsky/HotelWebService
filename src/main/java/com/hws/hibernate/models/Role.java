package com.hws.hibernate.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
}