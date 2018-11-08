package com.swm.datatracker.models;


import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

//-------------------------------------------- CONSTRUCTORS ---------------------------------------------\\

    public Status() {
    }

    public Status(String name) {
        this.name = name;
    }

    public Status(long id, String name) {
        this.id = id;
        this.name = name;
    }

//------------------------------------------------------------------------------------------------------\\


//-------------------------------------------- GETTERS/SETTERS ---------------------------------------------\\

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



//------------------------------------------------------------------------------------------------------\\

}

