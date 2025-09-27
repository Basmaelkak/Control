package com.example.demo2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ImmobilierLocationId implements Serializable {
    @Column(name = "immobilierid")
    private long immobilierId;

    @Column(name = "locationid")
    private long locationId;

    public ImmobilierLocationId() {
    }

    public ImmobilierLocationId(long immobilierId, long locationId) {
        this.immobilierId = immobilierId;
        this.locationId = locationId;
    }

    public long getImmobilierId() {
        return immobilierId;
    }

    public void setImmobilierId(long immobilierId) {
        this.immobilierId = immobilierId;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }
}

