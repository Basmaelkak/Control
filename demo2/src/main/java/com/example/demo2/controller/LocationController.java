package com.example.demo2.controller;

import com.example.demo2.entities.Location;
import com.example.demo2.repositry.LocationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LocationController {

        @Autowired
        private LocationRepository locationRepository;

        // Affiche le formulaire pour créer une nouvelle location
        @GetMapping("/signuplocation")
        public String showAddLocationForm(Location location) {
            return "add-location";
        }

        // Enregistre une nouvelle location dans la base de données
        @PostMapping("/addlocation")
        public String addLocation(@Valid Location location, BindingResult result, Model model) {
            if (result.hasErrors()) {
                return "add-location";
            }
            locationRepository.save(location);
            model.addAttribute("locations", locationRepository.findAll());
            return "index-location";
        }

        // Affiche le formulaire pour modifier une location existante
        @GetMapping("/editlocation/{id}")
        public String showUpdateForm(@PathVariable("id") long id, Model model) {
            Location location = locationRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid location Id:" + id));
            model.addAttribute("location", location);
            return "update-location";
        }

        // Met à jour une location existante dans la base de données
        @PostMapping("/updatelocation/{id}")
        public String updateLocation(@PathVariable("id") long id, @Valid Location location, BindingResult result, Model model) {
            if (result.hasErrors()) {
                location.setId(id);
                return "update-location";
            }

            locationRepository.save(location);
            model.addAttribute("locations", locationRepository.findAll());
            return "index-location";
        }

        // Supprime une location de la base de données
        @GetMapping("/deletelocation/{id}")
        public String deleteLocation(@PathVariable("id") long id, Model model) {
            Location location = locationRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid location Id:" + id));
            locationRepository.delete(location);
            model.addAttribute("locations", locationRepository.findAll());
            return "index-location";
        }
    }
