package com.example.demo2.entities;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity

public class Location {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate dateDebut;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate dateFin;
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

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public String getLocataire() {
        return locataire;
    }

    public void setLocataire(String locataire) {
        this.locataire = locataire;
    }
}


