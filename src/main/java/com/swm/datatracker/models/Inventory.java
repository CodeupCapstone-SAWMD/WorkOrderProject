package com.swm.datatracker.models;

import javax.persistence.*;

@Entity
@Table(name = "inventories")
public class Inventory {

//----------------------------------- ANNOTATIONS FOR DATABASE TABLE -----------------------------------\\

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false)
    private double price;

    @Column
    private long inventoryQuantity;

//------------------------------------------------------------------------------------------------------\\


//-------------------------------------------- CONSTRUCTORS ---------------------------------------------\\


    public Inventory() {
    }

    public Inventory(String name, String size, double price, long inventoryQuantity) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.inventoryQuantity = inventoryQuantity;
    }

    public Inventory(long id, String name, String size, double price, long inventoryQuantity) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.inventoryQuantity = inventoryQuantity;
    }
//------------------------------------------------------------------------------------------------------\\

//------------------------------------------ GETTERS/SETTERS -------------------------------------------\\

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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(long inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }


//------------------------------------------------------------------------------------------------------\\



}
