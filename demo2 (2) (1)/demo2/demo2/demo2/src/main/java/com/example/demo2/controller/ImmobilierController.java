package com.example.demo2.controller;
import com.example.demo2.entities.Immobilier;
import com.example.demo2.entities.ImmobilierLocation;
import com.example.demo2.entities.ImmobilierLocationId;
import com.example.demo2.entities.Location;
import com.example.demo2.repositry.ImmobilierLocationRepository;
import com.example.demo2.repositry.ImmobilierRepository;
import com.example.demo2.repositry.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@Controller
public class ImmobilierController {


        @Autowired
        private ImmobilierRepository immobilierRepository;
        @Autowired
    private LocationRepository locationRepository;
        @Autowired
    private ImmobilierLocationRepository immobilierLocationRepository;
    @GetMapping("/")
    public String redirectToImmobiliers() {

        return "redirect:/immobiliers"; // Redirige vers /immobiliers
    }
    @GetMapping("/immobiliers")
    public String showImmobilierList(Model model) {
        model.addAttribute("immobiliers", immobilierRepository.findAll());
        return "immobiliers";
    }

    // Display the form for adding a new immobilier
    @GetMapping("/addimmobilier")
    public String showAddImmobilierForm(Model model) {
        model.addAttribute("immobilier", new Immobilier());  // Add new Immobilier instance to the model
        model.addAttribute("immobiliers", immobilierRepository.findAll());
        model.addAttribute("location", new Location());
        return "add-immobilier";
    }
    @PostMapping("/addimmobilier")
    public String addImmobilier(@Valid @ModelAttribute("immobilier") Immobilier immobilier,BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-immobilier"; // Retourne au formulaire en cas d'erreur
        }
        immobilierRepository.save(immobilier); // Sauvegarde la promotion
        model.addAttribute("immobiliers", immobilierRepository.findAll());
        return "immobiliers"; // Redirige vers la page de la liste des immobiliers
    }
    @PostMapping("/addImmloc")
    public String addImmLoc(@RequestParam long immobilierId, @RequestParam long locationId, Model model) {

        Immobilier immobilier = immobilierRepository.findById(immobilierId)
                .orElseThrow(() -> new RuntimeException("immobilier introuvable"));
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new RuntimeException("location introuvable"));
        ImmobilierLocationId li = new ImmobilierLocationId();
        li.setImmobilier(immobilierId);
        li.setLocation(locationId);
        model.addAttribute("li",li);
        // Créer l'objet immloc et l'assigner
        ImmobilierLocation immloc = new ImmobilierLocation();
        immloc.setId(li);
        immloc.setImmobilier(immobilier);
        immloc.setLocation(location);
        model.addAttribute("locations", locationRepository.findAll());
        model.addAttribute("immobiliers", immobilierRepository.findAll());
        immobilierLocationRepository.save(immloc);
        return "immobiliers";
    }
    @GetMapping("/showimmloc/{id}")
    public String showimmloc(@PathVariable("id") long id, Model model) {
        Immobilier immobilier = immobilierRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid immobilier Id: " + id));
        List<ImmobilierLocation> loc = immobilierLocationRepository.findAllByImmobilier(immobilier);

        model.addAttribute("Listedesloc", loc);
        model.addAttribute("immobiliers", immobilierRepository.findAll());
        return "locations"; // Redirige vers la page immobiliers après suppression
    }
    @GetMapping("/deleteImmobilier/{id}")
    public String deleteImmobilier(@PathVariable("id") long id, Model model) {
        Immobilier immobilier = immobilierRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid immobilier Id: " + id));
        immobilierRepository.delete(immobilier);
        model.addAttribute("immobiliers", immobilierRepository.findAll());
        return "immobiliers"; // Redirige vers la page immobiliers après suppression
    }
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Immobilier immobilier = immobilierRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid immobilier Id: " + id));
        model.addAttribute("immobilier", immobilier);
        return "update"; // Nom de la vue pour mettre à jour un immobilier
    }
    @PostMapping("/update/{id}")
    public String UpdateForm(@PathVariable("id") long id, @Valid Immobilier immobilier, BindingResult result, Model model) {
        if (result.hasErrors()) {
            immobilier.setId(id);
            return "edit"; // Retourne au formulaire de mise à jour en cas d'erreur
        }

        immobilierRepository.save(immobilier);
        model.addAttribute("immobiliers", immobilierRepository.findAll());
        return "immobiliers"; // Redirige vers la page immobilier après mise à jour
    }
    }




