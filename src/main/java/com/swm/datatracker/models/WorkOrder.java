package com.swm.datatracker.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//@Entity
//@Table(name = "work_orders")
public class WorkOrder {

    @Id
    @GeneratedValue
    private long Id;

    @Column(nullable = false, length = 254)
    private String description;

    @Column(nullable = false)
    private String notes;

    @OneToOne
    private long categoryId;

    @OneToOne
    private long status;

    @OneToOne
    private long requestUserId;

    @Column(nullable = false)
    private long streetNumber;

    @Column(nullable = false, length = 100)
    private String streetName;

    @Column(nullable = false)
    private long zipCode;

    @Column(nullable = false)
    private Date submittedDate;


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

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
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
