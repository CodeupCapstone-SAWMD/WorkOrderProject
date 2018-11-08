package com.swm.datatracker.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "work_orders")
public class WorkOrder {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 254)
    private String description;

    @Column(nullable = false)
    private String notes;

    @OneToOne
    private Category categoryId;

    @OneToOne
    private Status statusId;

    @OneToOne
    private User requestUserId;

    @Column(nullable = false)
    private long streetNumber;

    @Column(nullable = false, length = 100)
    private String streetName;

    @Column(nullable = false)
    private long zipCode;

    @Column
    private Date submittedDate;

    public WorkOrder(){};

    public WorkOrder(long id, String description, String notes, Category categoryId, Status statusId, User requestUserId, long streetNumber, String streetName, long zipCode, Date submittedDate) {
        this.id = id;
        this.description = description;
        this.notes = notes;
        this.categoryId = categoryId;
        this.statusId = statusId;
        this.requestUserId = requestUserId;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.submittedDate = submittedDate;
    }

    // constructor with all fields except id
    public WorkOrder(String description, String notes, long categoryId, long status, long requestUserId, long streetNumber, String streetName, long zipCode, Date submittedDate) {
        this.description = description;
        this.notes = notes;
        this.categoryId = categoryId;
        this.status = status;
        this.requestUserId = requestUserId;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.submittedDate = submittedDate;
    }

    // constructor without id or date
    public WorkOrder(String description, String notes, long categoryId, long status, long requestUserId, long streetNumber, String streetName, long zipCode) {
        this.description = description;
        this.notes = notes;
        this.categoryId = categoryId;
        this.status = status;
        this.requestUserId = requestUserId;
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

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public long getRequestUserId() {
        return requestUserId;
    }

    public void setRequestUserId(long requestUserId) {
        this.requestUserId = requestUserId;
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

