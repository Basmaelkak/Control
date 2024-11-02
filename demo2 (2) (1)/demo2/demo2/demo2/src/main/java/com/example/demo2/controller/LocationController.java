package com.example.demo2.controller;

import com.example.demo2.entities.Immobilier;
import com.example.demo2.entities.Location;
import com.example.demo2.repositry.ImmobilierLocationRepository;
import com.example.demo2.repositry.ImmobilierRepository;
import com.example.demo2.repositry.LocationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ImmobilierRepository immobilierRepository;
    @Autowired
    private ImmobilierLocationRepository immobilierLocationRepository;

    @GetMapping("/location")
    public String showAddForm(Model model) {
        model.addAttribute("location", new Location());
        model.addAttribute("locations", locationRepository.findAll());
        return "immobiliers";
    }
@GetMapping("/addlocation")
public String showAddLocationForm(@ModelAttribute("location") Location location ,Model model) {
        return "add-immobilier";
}

// Enregistre une nouvelle location dans la base de données
@PostMapping("/addlocation")
public String addLocation(@ModelAttribute("location") Location location , BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "add-immobilier";
    }
    locationRepository.save(location);
    model.addAttribute("locations", locationRepository.findAll());
    model.addAttribute("immobiliers", immobilierRepository.findAll());
    return "immobiliers";
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

