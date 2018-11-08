package com.swm.datatracker.models;


import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

//-------------------------------------------- CONSTRUCTORS ---------------------------------------------\\

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(long id, String name) {
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
