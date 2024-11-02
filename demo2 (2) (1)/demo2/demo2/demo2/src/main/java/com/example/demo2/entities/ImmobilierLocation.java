package com.example.demo2.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class ImmobilierLocation implements Serializable {
    @EmbeddedId
    private ImmobilierLocationId id;
    @ManyToOne
    @JoinColumn(name = "location", insertable = false, updatable = false)
    private Location location;
    @ManyToOne
    @JoinColumn(name = "immobilier", insertable = false, updatable = false)
    private Immobilier immobilier;

    public ImmobilierLocation() {
    }

    public ImmobilierLocationId getId() {
        return id;
    }

    public void setId(ImmobilierLocationId id) {
        this.id = id;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Immobilier getImmobilier() {
        return immobilier;
    }

    public void setImmobilier(Immobilier immobilier) {
        this.immobilier = immobilier;
    }
}

