package com.example.demo2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ImmobilierLocationId implements Serializable {
    private long immobilier;

    private long location;

    public ImmobilierLocationId() {
    }

    public ImmobilierLocationId(long immobilierId, long locationId) {
        this.immobilier = immobilierId;
        this.location = locationId;
    }

    public long getImmobilier() {
        return immobilier;
    }

    public void setImmobilier(long immobilierId) {
        this.immobilier = immobilierId;
    }

    public long getLocation() {
        return location;
    }

    public void setLocation(long locationId) {
        this.location = locationId;
    }
}

