package com.hws.hibernate.models;

import javax.persistence.*;
import java.util.Date;

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

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
     public Date getInsertTime() {
        return insertTime;
    }
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
}
