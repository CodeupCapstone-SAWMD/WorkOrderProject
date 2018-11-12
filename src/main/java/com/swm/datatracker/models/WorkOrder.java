package com.swm.datatracker.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "work_order")
public class WorkOrder {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 254)
    private String description;

    @Column(nullable = false)
    private String notes;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name="status_id")
    private Status status;

    @OneToOne
//    @JoinColumn(name="user_id")
    private User customer;

    @OneToOne
//    @JoinColumn(name="user_id")
    private User employee;

    @Column(nullable = false)
    private long streetNumber;

    @Column(nullable = false, length = 100)
    private String streetName;

    @Column(nullable = false)
    private long zipCode;

    @Column
    private Date submittedDate;

    public WorkOrder(){}

    public WorkOrder(long id, String description, String notes, Category category, Status status, User customer, User employee, long streetNumber, String streetName, long zipCode, Date submittedDate) {
        this.id = id;
        this.description = description;
        this.notes = notes;
        this.category = category;
        this.status = status;
        this.customer = customer;
        this.employee = employee;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.submittedDate = submittedDate;
    }

    // constructor with all fields except id
    public WorkOrder(String description, String notes, Category category, Status status, User customer, User employee, long streetNumber, String streetName, long zipCode, Date submittedDate) {
        this.description = description;
        this.notes = notes;
        this.category = category;
        this.status = status;
        this.customer = customer;
        this.employee = employee;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.submittedDate = submittedDate;
    }

    // constructor without id or date
    public WorkOrder(String description, String notes, Category category, Status status, User customer, User employee, long streetNumber, String streetName, long zipCode) {
        this.description = description;
        this.notes = notes;
        this.category = category;
        this.status = status;
        this.customer = customer;
        this.employee = employee;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.zipCode = zipCode;
    }

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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public long getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(long streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }
}

