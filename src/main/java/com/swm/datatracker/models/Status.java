package com.swm.datatracker.models;


import org.hibernate.jdbc.Work;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="status")
    private List<WorkOrder> workOrders;

    public Status() {
    }

    public Status(String name, List<WorkOrder> workOrders) {
        this.name = name;
        this.workOrders = workOrders;
    }

    public Status(long id, String name, List<WorkOrder> workOrders) {
        this.id = id;
        this.name = name;
        this.workOrders = workOrders;
    }

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

    public List<WorkOrder> getWorkOrders() {
        return workOrders;
    }

    public void setWorkOrders(List<WorkOrder> workOrders) {
        this.workOrders = workOrders;
    }
}

