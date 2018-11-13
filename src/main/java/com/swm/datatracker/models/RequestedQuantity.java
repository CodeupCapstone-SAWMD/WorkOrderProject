package com.swm.datatracker.models;

import javax.persistence.Entity;

@Entity
public class RequestedQuantity {

    private long quantity;

    public RequestedQuantity() {
    }

    public RequestedQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
