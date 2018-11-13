package com.swm.datatracker.models;

import org.hibernate.jdbc.Work;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inventory")
public class Inventory {

//----------------------------------- ANNOTATIONS FOR DATABASE TABLE -----------------------------------\\

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String size;

    @Column(nullable = false, precision = 7, scale = 2)
    private double price;

    @Column
    private long quantity;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "inventory")
    private List<WorkOrder> workOrderList;

//------------------------------------------------------------------------------------------------------\\


//-------------------------------------------- CONSTRUCTORS ---------------------------------------------\\


    public Inventory() {
    }

    public Inventory(String name, String size, double price, long quantity, List<WorkOrder> workOrderList) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
        this.workOrderList = workOrderList;
    }

    public Inventory(long id, String name, String size, double price, long quantity, List<WorkOrder> workOrderList) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.quantity = quantity;
        this.workOrderList = workOrderList;

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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public List<WorkOrder> getWorkOrderList() {
        return workOrderList;
    }

    public void setWorkOrderList(List<WorkOrder> workOrderList) {
        this.workOrderList = workOrderList;
    }

    //------------------------------------------------------------------------------------------------------\\



}
