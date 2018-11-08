package com.swm.datatracker.models;


import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String description;

//-------------------------------------------- CONSTRUCTORS ---------------------------------------------\\

    public Category() {
    }

    public Category(String description) {
        this.description = description;
    }

    public Category(long id, String description) {
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
