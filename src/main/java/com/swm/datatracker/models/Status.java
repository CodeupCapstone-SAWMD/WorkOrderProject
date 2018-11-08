package com.swm.datatracker.models;


import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String description;

//-------------------------------------------- CONSTRUCTORS ---------------------------------------------\\

    public Status() {
    }

    public Status(String description) {
        this.description = description;
    }

    public Status(long id, String description) {
        this.id = id;
        this.description = description;
    }

//------------------------------------------------------------------------------------------------------\\


//-------------------------------------------- GETTERS/SETTERS ---------------------------------------------\\

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


//------------------------------------------------------------------------------------------------------\\

}

