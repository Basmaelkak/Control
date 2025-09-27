package com.example.demo2.controller;
import com.example.demo2.entities.Immobilier;
import com.example.demo2.entities.ImmobilierLocation;
import com.example.demo2.repositry.ImmobilierLocationRepository;
import com.example.demo2.repositry.ImmobilierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
public class ImmobilierController {


        @Autowired
        private ImmobilierRepository immobilierRepository;

        @GetMapping("/immobiliers")
        public String showAddImmobilierForm( Immobilier immobilier , Model model) {
            model.addAttribute("immobiliers", immobilierRepository.findAll());
            return "immobiliers";
        }

        @PostMapping("/addimmobilier")
        public String addImmobilier(@Valid Immobilier immobilier, BindingResult result, Model model) {
            if (result.hasErrors()) {
                return "add-immobilier";
            }

            immobilierRepository.save(immobilier);
            model.addAttribute("immobiliers", immobilierRepository.findAll());
            return "immobiliers";
        }

        @GetMapping("/editimmobilier/{id}")
        public String showUpdateForm(@PathVariable("id") long id, Model model) {
            Immobilier immobilier = immobilierRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid immobilier Id:" + id));
            model.addAttribute("immobilier", immobilier);
            return "update-immobilier";
        }

        @PostMapping("/updateimmobilier/{id}")
        public String updateImmobilier(@PathVariable("id") long id, @Valid Immobilier immobilier, BindingResult result, Model model) {
            if (result.hasErrors()) {
                immobilier.setId(id);
                return "update-immobilier";
            }

            immobilierRepository.save(immobilier);
            model.addAttribute("immobiliers", immobilierRepository.findAll());
            return "index-immobilier";
        }

        @GetMapping("/deleteimmobilier/{id}")
        public String deleteImmobilier(@PathVariable("id") long id, Model model) {
            Immobilier immobilier = immobilierRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid immobilier Id:" + id));
            immobilierRepository.delete(immobilier);
            model.addAttribute("immobiliers", immobilierRepository.findAll());
            return "index-immobilier";
        }

        // Ajout d'un exemple de gestion d'ImmobilierLocation

        @GetMapping("/add-location/{immobilierId}")
        public String showAddLocationForm(@PathVariable("immobilierId") long immobilierId, Model model) {
            Immobilier immobilier = immobilierRepository.findById(immobilierId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid immobilier Id:" + immobilierId));
            ImmobilierLocation immobilierLocation = new ImmobilierLocation();
            immobilierLocation.setImmobilier(immobilier);

            model.addAttribute("immobilierLocation", immobilierLocation);
            return "add-immobilier-location";
        }

        @PostMapping("/add-location")
        public String addLocationToImmobilier(@Valid ImmobilierLocation immobilierLocation, BindingResult result, Model model) {
            if (result.hasErrors()) {
                return "add-immobilier-location";
            }

            model.addAttribute("immobiliers", immobilierRepository.findAll());
            return "index-immobilier";
        }
    }




