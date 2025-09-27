package com.example.demo2.entities;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity

public class Location {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Date dateDebut;
        private Date dateFin;
        private String locataire;

    public Location() {
    }
// getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getLocataire() {
        return locataire;
    }

    public void setLocataire(String locataire) {
        this.locataire = locataire;
    }
}


